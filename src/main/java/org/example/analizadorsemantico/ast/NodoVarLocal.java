package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

public class NodoVarLocal extends NodoSentencia {
    private final Token token;
    private final NodoExpresion inicializador;

    public NodoVarLocal(Token token, NodoExpresion inicializador) {
        this.token = token;
        this.inicializador = inicializador;
    }

    public void chequear() {
        String nombre = token.lexema();
        Tipo tipo = inicializador.chequear();
        if (tipo instanceof TipoNull || tipo instanceof TipoVoid) {
            throw new ErrorSemantico(token, "No se puede inferir el tipo de la variable " + nombre
                    + " a partir de un inicializador de tipo " + tipo);
        }
        if (TablaDeSimbolos.ts.getUnidadActual().getParametro(nombre) != null) {
            throw new ErrorSemantico(token, "La variable " + nombre + " tiene el mismo nombre que un parametro");
        }
        if (TablaDeSimbolos.ts.getVariableLocal(nombre) != null) {
            throw new ErrorSemantico(token, "La variable " + nombre + " ya esta declarada");
        }
        TablaDeSimbolos.ts.agregarVariableLocal(new VariableLocal(token, tipo));
    }

    public void chequearComoCuerpo() {
        throw new ErrorSemantico(token, "La declaracion de " + token.lexema()
                + " no puede ser el cuerpo directo de un if, else o while");
    }
}
