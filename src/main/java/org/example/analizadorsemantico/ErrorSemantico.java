package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class ErrorSemantico extends RuntimeException {
    private final String lexema;
    private final int nroLinea;

    public ErrorSemantico(Token token, String mensaje) {
        super(mensaje);
        this.lexema = token.lexema();
        this.nroLinea = token.nroDeLinea();
    }

    public int getNroLinea() {
        return nroLinea;
    }

    public String getLexema() {
        return lexema;
    }
}
