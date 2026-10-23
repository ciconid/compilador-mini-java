package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

public class NodoAccesoVar extends NodoExpresion {
    private final Token token;

    public NodoAccesoVar(Token token) {
        this.token = token;
    }

    public Tipo chequear() {
        String nombre = token.lexema();
        VariableLocal local = TablaDeSimbolos.ts.getVariableLocal(nombre);
        if (local != null) {
            return local.getTipo();
        }
        Unidad unidad = TablaDeSimbolos.ts.getUnidadActual();
        Parametro parametro = unidad == null ? null : unidad.getParametro(nombre);
        if (parametro != null) {
            return parametro.getTipo();
        }
        Atributo atributo = TablaDeSimbolos.ts.getClaseActual().getAtributo(nombre);
        if (atributo == null) {
            throw new ErrorSemantico(token, "La variable " + nombre + " no esta declarada");
        }
        if (TablaDeSimbolos.ts.enContextoEstatico()) {
            throw new ErrorSemantico(token, "No se puede acceder al atributo " + nombre + " desde un metodo estatico");
        }
        if (TablaDeSimbolos.ts.esReferenciaAdelantada(atributo)) {
            throw new ErrorSemantico(token, "El atributo " + nombre
                    + " no puede usarse en un inicializador antes de su declaracion");
        }
        return atributo.getTipo();
    }

    public boolean esAsignable() {
        return true;
    }
}
