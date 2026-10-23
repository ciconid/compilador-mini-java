package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TablaDeSimbolos {
    public static TablaDeSimbolos ts;

    private final Map<String, ClaseOInterfaz> clasesOInterfaces;
    private ClaseOInterfaz claseActual;
    private Unidad unidadActual;
    private Deque<Map<String, VariableLocal>> ambitos;

    public TablaDeSimbolos() {
        clasesOInterfaces = new LinkedHashMap<>();
        ambitos = new ArrayDeque<>();
        cargarPredefinidas();
    }

    public void chequeoDeclaraciones() {
        for (ClaseOInterfaz claseOInterfaz : clasesOInterfaces.values()) {
            claseOInterfaz.estaBienDeclarado();
        }
        for (ClaseOInterfaz claseOInterfaz : clasesOInterfaces.values()) {
            claseOInterfaz.consolidar();
        }
    }

    public void chequeoSentencias() {
        for (ClaseOInterfaz claseOInterfaz : clasesOInterfaces.values()) {
            claseActual = claseOInterfaz;
            for (Unidad unidad : claseOInterfaz.unidadesDeclaradas) {
                unidadActual = unidad;
                ambitos = new ArrayDeque<>();
                unidad.bloque.chequear();
            }
        }
    }

    public ClaseOInterfaz getClaseActual() {
        return claseActual;
    }

    public Unidad getUnidadActual() {
        return unidadActual;
    }

    public void abrirAmbito() {
        ambitos.push(new HashMap<>());
    }

    public void cerrarAmbito() {
        ambitos.pop();
    }

    public void agregarVariableLocal(VariableLocal variable) {
        ambitos.peek().put(variable.nombre, variable);
    }

    public VariableLocal getVariableLocal(String nombre) {
        for (Map<String, VariableLocal> ambito : ambitos) {
            VariableLocal variable = ambito.get(nombre);
            if (variable != null) {
                return variable;
            }
        }
        return null;
    }

    ClaseOInterfaz getClaseOInterfaz(String nombre) {
        return clasesOInterfaces.get(nombre);
    }

    boolean tieneSubtipoDirecto(String nombre) {
        for (ClaseOInterfaz claseOInterfaz : clasesOInterfaces.values()) {
            if (claseOInterfaz.heredaDirectamenteDe(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void agregarClaseOInterfaz(ClaseOInterfaz claseOInterfaz) {
        if (clasesOInterfaces.containsKey(claseOInterfaz.nombre)) {
            throw new ErrorSemantico(claseOInterfaz.token, "La clase o interfaz " + claseOInterfaz.nombre
                    + " ya esta declarada");
        }
        clasesOInterfaces.put(claseOInterfaz.nombre, claseOInterfaz);
        claseActual = claseOInterfaz;
    }

    public void setModificador(Token modificador) {
        claseActual.modificador = modificador;
    }

    public void setPermits(Token tokenPermits, List<Token> permitidos) {
        claseActual.tokenPermits = tokenPermits;
        claseActual.permitidos = permitidos;
    }

    public void setParametroGenerico(Token token) {
        claseActual.parametroGenericoOpcional = token.lexema();
    }

    public void setSuperclase(TipoReferencia superclase) {
        ((Clase) claseActual).superclase = superclase;
    }

    public void setInterfacesImplementadas(List<TipoReferencia> interfaces) {
        ((Clase) claseActual).interfacesImplementadas = interfaces;
    }

    public void setSuperInterfaces(List<TipoReferencia> superInterfaces) {
        ((Interfaz) claseActual).superInterfaces = superInterfaces;
    }

    public void agregarAtributo(Atributo atributo) {
        ((Clase) claseActual).agregarAtributo(atributo);
    }

    public void agregarMetodo(Metodo metodo) {
        claseActual.agregarMetodo(metodo);
    }

    public void agregarConstructor(Constructor constructor) {
        ((Clase) claseActual).agregarConstructor(constructor);
    }

    private void cargarPredefinidas() {
        Clase object = new Clase(tokenClase("Object"));
        object.superclase = null;
        object.agregarMetodo(metodo("debugPrint", true, new TipoVoid(), "i", new TipoInt()));
        object.agregarMetodo(metodo("toString", false, tipoString(), null, null));
        clasesOInterfaces.put(object.nombre, object);

        Clase string = new Clase(tokenClase("String"));
        clasesOInterfaces.put(string.nombre, string);

        Clase system = new Clase(tokenClase("System"));
        system.agregarMetodo(metodo("read", true, new TipoInt(), null, null));
        system.agregarMetodo(metodo("printB", true, new TipoVoid(), "b", new TipoBoolean()));
        system.agregarMetodo(metodo("printC", true, new TipoVoid(), "c", new TipoChar()));
        system.agregarMetodo(metodo("printI", true, new TipoVoid(), "i", new TipoInt()));
        system.agregarMetodo(metodo("printS", true, new TipoVoid(), "s", tipoString()));
        system.agregarMetodo(metodo("println", true, new TipoVoid(), null, null));
        system.agregarMetodo(metodo("printBln", true, new TipoVoid(), "b", new TipoBoolean()));
        system.agregarMetodo(metodo("printCln", true, new TipoVoid(), "c", new TipoChar()));
        system.agregarMetodo(metodo("printIln", true, new TipoVoid(), "i", new TipoInt()));
        system.agregarMetodo(metodo("printSln", true, new TipoVoid(), "s", tipoString()));
        clasesOInterfaces.put(system.nombre, system);
    }

    private Metodo metodo(String nombre, boolean esEstatico, Tipo tipoRetorno, String nombreParametro, Tipo tipoParametro) {
        Metodo metodo = new Metodo(tokenMetVar(nombre), esEstatico, tipoRetorno);
        if (nombreParametro != null) {
            metodo.agregarParametro(tokenMetVar(nombreParametro), tipoParametro);
        }
        return metodo;
    }

    private TipoReferencia tipoString() {
        return new TipoReferencia(tokenClase("String"), null);
    }

    private Token tokenClase(String lexema) {
        return new Token("idClase", lexema, 0);
    }

    private Token tokenMetVar(String lexema) {
        return new Token("idMetVar", lexema, 0);
    }
}
