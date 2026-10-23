package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

import java.util.List;

public class NodoLlamadaEstatica extends NodoExpresion {
    private final Token tokenClase;
    private final Token token;
    private final List<NodoExpresion> argumentos;

    public NodoLlamadaEstatica(Token tokenClase, Token token, List<NodoExpresion> argumentos) {
        this.tokenClase = tokenClase;
        this.token = token;
        this.argumentos = argumentos;
    }

    public Tipo chequear() {
        String nombreClase = tokenClase.lexema();
        String nombre = token.lexema();
        ClaseOInterfaz clase = TablaDeSimbolos.ts.getClaseOInterfaz(nombreClase);
        if (clase == null) {
            throw new ErrorSemantico(tokenClase, "La clase " + nombreClase + " no esta declarada");
        }
        if (!(clase instanceof Clase)) {
            throw new ErrorSemantico(tokenClase, nombreClase + " no es una clase");
        }
        Metodo metodo = clase.getMetodo(nombre, argumentos.size());
        if (metodo == null) {
            throw new ErrorSemantico(token, "El metodo " + nombre + " con " + argumentos.size()
                    + " parametros no esta declarado en " + nombreClase);
        }
        if (!metodo.esEstatico()) {
            throw new ErrorSemantico(token, "El metodo " + nombre + " no es estatico y no puede invocarse usando "
                    + "solo el nombre de la clase " + nombreClase);
        }
        metodo.chequearArgumentos(argumentos, new TipoReferencia(tokenClase, null), token);
        return metodo.getTipoRetorno();
    }

    public boolean esLlamada() {
        return true;
    }
}
