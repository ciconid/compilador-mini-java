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
        System.out.println("Char actual: " + caracterActual + " - Val: " + (int) caracterActual + " - Line: " + gestorDeFuente.getLineNumber());
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
        } else if (caracterActual == '/') {
            actualizarLexema();
            actualizarCaracterActual();
            return e4();
        } else if (caracterActual == '"') {
            actualizarLexema();
            actualizarCaracterActual();
            return e6();
        } else if (caracterActual == '+') {
            actualizarLexema();
            actualizarCaracterActual();
            return e9();
        } else if (esSimboloPuntuacion(caracterActual)) {
            actualizarLexema();
            actualizarCaracterActual();
            return switch (lexema) {
                case "(" -> crearToken("puParentesisAbre");
                case ")" -> crearToken("puParentesisCierra");
                case "{" -> crearToken("puLlaveAbre");
                case "}" -> crearToken("puLlaveCierra");
                case "[" -> crearToken("puCorcheteAbre");
                case "]" -> crearToken("puCorcheteCierra");
                case ";" -> crearToken("puPuntoYComa");
                case "," -> crearToken("puComa");
                case "." -> crearToken("puPunto");
                case ":" -> crearToken("puDosPuntos");
                default -> throw new RuntimeException("Simbolo Puntuacion invalido");
            };
        } else if (caracterActual == '=') {
            actualizarLexema();
            actualizarCaracterActual();
            return e11();
        } else if (caracterActual == '>') {
            actualizarLexema();
            actualizarCaracterActual();
            return e13();
        } else if (caracterActual == '<') {
            actualizarLexema();
            actualizarCaracterActual();
            return e15();
        } else if (caracterActual == '!') {
            actualizarLexema();
            actualizarCaracterActual();
            return e17();
        } else if (caracterActual == '-') {
            actualizarLexema();
            actualizarCaracterActual();
            return e19();
        } else if (caracterActual == '*') {
            actualizarLexema();
            actualizarCaracterActual();
            return crearToken("opMultiplicacion");
        } else if (caracterActual == '%') {
            actualizarLexema();
            actualizarCaracterActual();
            return crearToken("opModulo");
        } else if (caracterActual == '&') {
            actualizarLexema();
            actualizarCaracterActual();
            return e21();
        } else if (caracterActual == '|') {
            actualizarLexema();
            actualizarCaracterActual();
            return e22();
        } else if (caracterActual == '\'') {
            actualizarLexema();
            actualizarCaracterActual();
            return e23();
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
            return switch (lexema) {
                case "class" -> crearToken("prClass");
                case "boolean" -> crearToken("prBoolean");
                case "if" -> crearToken("prIf");
                case "this" -> crearToken("prThis");
                case "extends" -> crearToken("prExtends");
                case "char" -> crearToken("prChar");
                case "else" -> crearToken("prElse");
                case "new" -> crearToken("prNew");
                case "interface" -> crearToken("prInterface");
                case "int" -> crearToken("prInt");
                case "while" -> crearToken("prWhile");
                case "null" -> crearToken("prNull");
                case "implements" -> crearToken("prImplements");
                case "void" -> crearToken("prVoid");
                case "return" -> crearToken("prReturn");
                case "true" -> crearToken("prTrue");
                case "static" -> crearToken("prStatic");
                case "public" -> crearToken("prPublic");
                case "var" -> crearToken("prVar");
                case "false" -> crearToken("prFalse");
                default -> crearToken("idMetVal");
            };

        }
    }

    private Token e2() {
        if (Character.isLetterOrDigit(caracterActual) || caracterActual == '_') {
            actualizarLexema();
            actualizarCaracterActual();
            return e3();
        } else {
            return crearToken("idGen");
        }
    }

    private Token e3() {
        if (Character.isLetterOrDigit(caracterActual) || caracterActual == '_') {
            actualizarLexema();
            actualizarCaracterActual();
            return e3();
        } else {
            return crearToken("idClase");
        }
    }

    private Token e4() {
        if (caracterActual == '/') {
            actualizarLexema();
            actualizarCaracterActual();
            return e5();
        } else {
            return crearToken("opDivision");
        }
    }

    private Token e5() {
        if (caracterActual == SourceManager.END_OF_FILE) {
            return e99();
        }
        if (caracterActual != '\n') {
            actualizarCaracterActual();
            return e5();
        }
        actualizarCaracterActual();
        lexema = "";
        return e0();
    }

    private Token e6() {
        if (caracterActual == '"') {
            actualizarLexema();
            actualizarCaracterActual();
            return e7();
        } else if (caracterActual == '\\') {
            actualizarLexema();
            actualizarCaracterActual();
            return e8();
        } else if (esCaracterVisible(caracterActual)) {
            actualizarLexema();
            actualizarCaracterActual();
            return e6();
        } else {
            throw new RuntimeException("Caracter invalido para String");
        }
    }

    private Token e7() {
        return crearToken("stringLiteral");
    }

    private Token e8() {
        if (esCaracterVisible(caracterActual)) {
            actualizarLexema();
            actualizarCaracterActual();
            return e6();
        } else {
            throw new RuntimeException("Caracter invalido para String");
        }
    }

    private Token e9() {
        if (caracterActual == '+') {
            actualizarLexema();
            actualizarCaracterActual();
            return e10();
        }
        return crearToken("opSuma");
    }

    private Token e10() {
        return crearToken("opIncremento");
    }

    private Token e11() {
        if (caracterActual == '=') {
            actualizarLexema();
            actualizarCaracterActual();
            return e12();
        }
        return crearToken("opAsignacion");
    }

    private Token e12() {
        return crearToken("opIgualdad");
    }

    private Token e13() {
        if (caracterActual == '=') {
            actualizarLexema();
            actualizarCaracterActual();
            return e14();
        }
        return crearToken("opMayor");
    }

    private Token e14() {
        return crearToken("opMayorIgual");
    }

    private Token e15() {
        if (caracterActual == '=') {
            actualizarLexema();
            actualizarCaracterActual();
            return e16();
        }
        return crearToken("opMenor");
    }

    private Token e16() {
        return crearToken("opMenorIgual");
    }

    private Token e17() {
        if (caracterActual == '=') {
            actualizarLexema();
            actualizarCaracterActual();
            return e18();
        }
        return crearToken("opNegacion");
    }

    private Token e18() {
        return crearToken("opDistinto");
    }

    private Token e19() {
        if (caracterActual == '-') {
            actualizarLexema();
            actualizarCaracterActual();
            return e20();
        }
        return crearToken("opResta");
    }

    private Token e20() {
        return crearToken("opDecremento");
    }

    private Token e21() {
        if (caracterActual == '&') {
            actualizarLexema();
            actualizarCaracterActual();
            return crearToken("opAnd");
        }
        throw new RuntimeException();
    }

    private Token e22() {
        if (caracterActual == '|') {
            actualizarLexema();
            actualizarCaracterActual();
            return crearToken("opOr");
        }
        throw new RuntimeException();
    }

    private Token e23() {
        if (caracterActual == '\\') {
            actualizarLexema();
            actualizarCaracterActual();
            return e24();
        } else if (esCaracterVisible(caracterActual)) {
            actualizarLexema();
            actualizarCaracterActual();
            return e25();
        } else {
            throw new RuntimeException();
        }
    }

    private Token e24() {
        if (esCaracterVisible(caracterActual)) {
            actualizarLexema();
            actualizarCaracterActual();
            return e25();
        }
        throw new RuntimeException();
    }

    private Token e25() {
        if (caracterActual == '\'') {
            actualizarLexema();
            actualizarCaracterActual();
            return crearToken("charLiteral");
        }
        throw new RuntimeException();
    }




    /*
    * private Token e24(){
        return null;
    }
    *
    * */

    private Token e99() {
        return new Token("EOF", "$", gestorDeFuente.getLineNumber());
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

    private Token crearToken(String tipo) {
        return new Token(tipo, lexema, gestorDeFuente.getLineNumber());
    }

    private boolean esCaracterVisible(char c) {
        return c >= 32 && c <= 126;
    }

    private boolean esSimboloPuntuacion(char c) {
        return switch (c) {
            case '(', ')', '{', '}', '[', ']', ',', ';', '.', ':' -> true;
            default -> false;
        };
    }
}
