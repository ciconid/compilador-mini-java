package org.example.analizadorsintactico;

public class ErrorSintactico extends RuntimeException {
    private final String lexema;
    private final int nroLinea;

    public ErrorSintactico(String lexema, int nroLinea) {
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
