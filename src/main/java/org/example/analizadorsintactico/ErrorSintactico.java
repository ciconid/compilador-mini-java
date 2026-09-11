package org.example.analizadorsintactico;

public class ErrorSintactico extends RuntimeException {
    private final String lexema;
    private final int nroLinea;
    private final String lexemasEsperados;

    public ErrorSintactico(String lexema, int nroLinea, String lexemasEsperados) {
        this.lexema = lexema;
        this.nroLinea = nroLinea;
        this.lexemasEsperados = lexemasEsperados;
    }

    public int getNroLinea() {
        return nroLinea;
    }

    public String getLexema() {
        return lexema;
    }

    public String getLexemasEsperados() {
        return lexemasEsperados;
    }
}
