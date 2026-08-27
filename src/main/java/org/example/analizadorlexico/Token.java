package org.example.analizadorlexico;

public record Token(String token, String lexema, int nroDeLinea) {
    @Override
    public String toString() {
        return "(" + token + "," + lexema + "," + nroDeLinea + ")";
    }
}
