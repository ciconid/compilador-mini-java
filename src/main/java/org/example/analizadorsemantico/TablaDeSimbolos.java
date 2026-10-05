package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TablaDeSimbolos {
    public static TablaDeSimbolos ts;

    private final Map<String, ClaseOInterfaz> clasesOInterfaces;
    private ClaseOInterfaz claseActual;

    public TablaDeSimbolos() {
        clasesOInterfaces = new LinkedHashMap<>();
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

    ClaseOInterfaz getClaseOInterfaz(String nombre) {
        return clasesOInterfaces.get(nombre);
    }

    public void agregarClaseOInterfaz(ClaseOInterfaz claseOInterfaz) {
        if (clasesOInterfaces.containsKey(claseOInterfaz.nombre)) {
            throw new ErrorSemantico(claseOInterfaz.token, "La clase o interfaz " + claseOInterfaz.nombre
                    + " ya esta declarada");
        }
        clasesOInterfaces.put(claseOInterfaz.nombre, claseOInterfaz);
        claseActual = claseOInterfaz;
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
