package org.example.analizadorlexico;

import org.example.sourcemanager.SourceManager;

import java.io.IOException;

public class AnalizadorLexico {
    private String lexema;
    private char caracterActual;
    private final SourceManager gestorDeFuente;

    public AnalizadorLexico(SourceManager gestorDeFuente) {
        lexema = "";
        caracterActual = ' ';
        this.gestorDeFuente = gestorDeFuente;
    }

    public Token proximoToken() {
        lexema = "";
        return e0();
    }

    private Token e0() {
        //System.out.println("Char actual: " + caracterActual);
        if (Character.isLowerCase(caracterActual)) {
            actualizarLexema();
            actualizarCaracterActual();
            return e1();
        } else if (Character.isUpperCase(caracterActual)) {
            actualizarLexema();
            actualizarCaracterActual();
            return e2();
        } else if (Character.isWhitespace(caracterActual) || caracterActual == ' ') {
            actualizarCaracterActual();
            return e0();
        } else if (caracterActual == SourceManager.END_OF_FILE) {
            return e99();
        } else {
            actualizarCaracterActual();
            return e0();
        }
    }

    private Token e1() {
        if (Character.isLetterOrDigit(caracterActual) || caracterActual == '_') {
            actualizarLexema();
            actualizarCaracterActual();
            return e1();
        } else {
            return new Token("idMetVal", lexema, gestorDeFuente.getLineNumber());
        }
    }

    private Token e2() {
        if (Character.isLetterOrDigit(caracterActual) || caracterActual == '_') {
            actualizarLexema();
            actualizarCaracterActual();
            return e3();
        } else {
            return new Token("idGen", lexema, gestorDeFuente.getLineNumber());
        }
    }

    private Token e3() {
        if (Character.isLetterOrDigit(caracterActual) || caracterActual == '_') {
            actualizarLexema();
            actualizarCaracterActual();
            return e3();
        } else {
            return new Token("idClase", lexema, gestorDeFuente.getLineNumber());
        }
    }

    private Token e99() {
        return new Token("EOF", lexema, gestorDeFuente.getLineNumber());
    }

    private void actualizarLexema() {
        lexema = lexema + caracterActual;
    }

    private void actualizarCaracterActual() {
        try {
            caracterActual = gestorDeFuente.getNextChar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
