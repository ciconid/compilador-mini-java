package org.example.analizadorsintactico;

public class TokensYLexemas {
//    public static final String puLlaveAbre = "{";

    public static String get(String nombreToken) {
        switch (nombreToken) {
            // Puntuación
            case "puParentesisAbre":
                return "(";
            case "puParentesisCierra":
                return ")";
            case "puLlaveAbre":
                return "{";
            case "puLlaveCierra":
                return "}";
            case "puCorcheteAbre":
                return "[";
            case "puCorcheteCierra":
                return "]";
            case "puPuntoYComa":
                return ";";
            case "puComa":
                return ",";
            case "puPunto":
                return ".";
            case "puDosPuntos":
                return ":";

            // Operadores aritméticos
            case "opDivision":
                return "/";
            case "opMultiplicacion":
                return "*";
            case "opModulo":
                return "%";
            case "opSuma":
                return "+";
            case "opResta":
                return "-";
            case "opIncremento":
                return "++";
            case "opDecremento":
                return "--";

            // Operadores de asignación / comparación
            case "opAsignacion":
                return "=";
            case "opIgualdad":
                return "==";
            case "opDistinto":
                return "!=";
            case "opMayor":
                return ">";
            case "opMayorIgual":
                return ">=";
            case "opMenor":
                return "<";
            case "opMenorIgual":
                return "<=";

            // Operadores lógicos
            case "opNegacion":
                return "!";
            case "opAnd":
                return "&&";
            case "opOr":
                return "||";

            // Palabras reservadas
            case "prClass":
                return "class";
            case "prBoolean":
                return "boolean";
            case "prIf":
                return "if";
            case "prThis":
                return "this";
            case "prExtends":
                return "extends";
            case "prChar":
                return "char";
            case "prElse":
                return "else";
            case "prNew":
                return "new";
            case "prInterface":
                return "interface";
            case "prInt":
                return "int";
            case "prWhile":
                return "while";
            case "prNull":
                return "null";
            case "prImplements":
                return "implements";
            case "prVoid":
                return "void";
            case "prReturn":
                return "return";
            case "prTrue":
                return "true";
            case "prStatic":
                return "static";
            case "prPublic":
                return "public";
            case "prVar":
                return "var";
            case "prFalse":
                return "false";

            // Identificadores y literales (sin lexema fijo)
            case "idMetVar":
                return "id de metodo o variable";
            case "idGen":
                return "id generico";
            case "idClase":
                return "id de clase";
            case "stringLiteral":
                return "literal string";
            case "charLiteral":
                return "literal char";
            case "intLiteral":
                return "literal int";
            case "EOF":
                return "EOF";

            default:
                return "[CASO NO CONTEMPLADO]";
        }
    }

}
