package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.LinkedHashMap;
import java.util.Map;

public class Clase extends ClaseOInterfaz {
    protected TipoReferencia superclase;
    protected TipoReferencia interfazImplementada;
    protected Map<String, Atributo> atributos;
    protected Map<Integer, Constructor> constructores;

    public Clase(Token token) {
        super(token);
        superclase = new TipoReferencia(new Token("idClase", "Object", 0), null);
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

    TipoReferencia getPadre() {
        return superclase;
    }

    void estaBienDeclarado() {
        if (superclase != null) {
            superclase.estaBienDeclarado(this);
            if (!(superclase.getReferenciada() instanceof Clase)) {
                throw new ErrorSemantico(superclase.token, superclase.nombre + " no es una clase");
            }
        }
        if (interfazImplementada != null) {
            interfazImplementada.estaBienDeclarado(this);
            if (!(interfazImplementada.getReferenciada() instanceof Interfaz)) {
                throw new ErrorSemantico(interfazImplementada.token, interfazImplementada.nombre
                        + " no es una interfaz");
            }
        }
        chequearHerenciaCircular();
        for (Atributo atributo : atributos.values()) {
            atributo.estaBienDeclarado(this);
        }
        chequearMetodos();
        for (Constructor constructor : constructores.values()) {
            constructor.estaBienDeclarado(this);
        }
    }
}
