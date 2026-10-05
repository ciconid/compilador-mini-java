package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Clase extends ClaseOInterfaz {
    protected TipoReferencia superclase;
    protected List<TipoReferencia> interfacesImplementadas;
    protected Map<String, Atributo> atributos;
    protected Map<Integer, Constructor> constructores;

    public Clase(Token token) {
        super(token);
        superclase = new TipoReferencia(new Token("idClase", "Object", 0), null);
        interfacesImplementadas = new ArrayList<>();
        atributos = new LinkedHashMap<>();
        constructores = new LinkedHashMap<>();
    }

    void agregarAtributo(Atributo atributo) {
        if (atributos.containsKey(atributo.nombre)) {
            throw new ErrorSemantico(atributo.token, "El atributo " + atributo.nombre
                    + " ya esta declarado en la clase " + nombre);
        }
        atributos.put(atributo.nombre, atributo);
    }

    void agregarConstructor(Constructor constructor) {
        String nombreConstructor = constructor.token.lexema();
        if (!nombreConstructor.equals(nombre)) {
            throw new ErrorSemantico(constructor.token, "El constructor " + nombreConstructor
                    + " no tiene el nombre de la clase " + nombre);
        }
        if (constructores.containsKey(constructor.aridad())) {
            throw new ErrorSemantico(constructor.token, "Ya existe un constructor con " + constructor.aridad()
                    + " parametros en la clase " + nombre);
        }
        constructores.put(constructor.aridad(), constructor);
    }

    List<TipoReferencia> getPadres() {
        return superclase == null ? List.of() : List.of(superclase);
    }

    void estaBienDeclarado() {
        if (superclase != null) {
            superclase.estaBienDeclarado(this);
            if (!(superclase.getReferenciada() instanceof Clase)) {
                throw new ErrorSemantico(superclase.token, superclase.nombre + " no es una clase");
            }
        }
        chequearListaDeInterfaces(interfacesImplementadas);
        chequearHerenciaCircular();
        for (Atributo atributo : atributos.values()) {
            atributo.estaBienDeclarado(this);
        }
        chequearMetodos();
        for (Constructor constructor : constructores.values()) {
            constructor.estaBienDeclarado(this);
        }
    }

    void consolidar() {
        if (consolidado) {
            return;
        }
        Map<String, Metodo> metodosPropios = metodos;
        if (superclase != null) {
            Clase padre = (Clase) superclase.getReferenciada();
            padre.consolidar();
            heredarAtributos(padre);
            heredarMetodos(List.of(superclase));
        }
        for (TipoReferencia interfazImplementada : interfacesImplementadas) {
            chequearContratoInterfaz(interfazImplementada, metodosPropios);
        }
        if (constructores.isEmpty()) {
            constructores.put(0, new Constructor(new Token("idClase", nombre, token.nroDeLinea())));
        }
        consolidado = true;
    }

    private void heredarAtributos(Clase padre) {
        String parametro = parametroAInstanciar(padre, superclase);
        Map<String, Atributo> consolidados = new LinkedHashMap<>();
        for (Atributo atributoPadre : padre.atributos.values()) {
            consolidados.put(atributoPadre.nombre, atributoPadre.instanciar(parametro, superclase.argumentoGenerico));
        }
        for (Atributo propio : atributos.values()) {
            if (consolidados.containsKey(propio.nombre)) {
                throw new ErrorSemantico(propio.token, "El atributo " + propio.nombre
                        + " ya esta declarado en un ancestro de la clase " + nombre);
            }
            consolidados.put(propio.nombre, propio);
        }
        atributos = consolidados;
    }

    private void chequearContratoInterfaz(TipoReferencia interfazImplementada, Map<String, Metodo> metodosPropios) {
        Interfaz interfaz = (Interfaz) interfazImplementada.getReferenciada();
        interfaz.consolidar();
        String parametro = parametroAInstanciar(interfaz, interfazImplementada);
        for (Metodo metodoInterfaz : interfaz.metodos.values()) {
            Metodo requerido = metodoInterfaz.instanciar(parametro, interfazImplementada.argumentoGenerico);
            Metodo implementacion = metodos.get(requerido.getClave());
            if (implementacion != null && !implementacion.esEstatico && implementacion.mismaSignatura(requerido)) {
                continue;
            }
            Metodo propio = metodosPropios.get(requerido.getClave());
            Token tokenError = propio != null ? propio.token : token;
            throw new ErrorSemantico(tokenError, "La clase " + nombre + " no implementa correctamente el metodo "
                    + requerido.nombre + " de la interfaz " + interfaz.nombre);
        }
    }
}
