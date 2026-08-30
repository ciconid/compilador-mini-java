package org.example.analizadorlexico;

public class ErrorLexico extends RuntimeException {
    private final String lexema;
    private final int nroLinea;

    public ErrorLexico(String lexema, int nroLinea) {
        this.lexema = lexema;
        this.nroLinea = nroLinea;
    }

    public int getNroLinea() {
        return nroLinea;
    }

    public String getLexema() {
        return lexema;
    }
}
