package org.example.analizadorsintactico;

import java.util.Arrays;
import java.util.List;

public class Primeros {

    public static final List<String> clase = Arrays.asList("prClass");
    public static final List<String> interfaz = Arrays.asList("prInterface");
    public static final List<String> miembro = Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen", "prStatic", "prVoid", "prPublic");
    public static final List<String> metodoInterfaz = Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen", "prVoid");
    public static final List<String> tipo = Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen");
    public static final List<String> tipoPrimitivo = Arrays.asList("prBoolean", "prChar", "prInt");
    public static final List<String> tipoReferencia = Arrays.asList("idClase");
    public static final List<String> listaArgsFormales = Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen");
    public static final List<String> sentencia = Arrays.asList("puPuntoYComa", "opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre", "prVar", "prReturn", "prIf", "prWhile", "puLlaveAbre");
    public static final List<String> asignacionYLlamada = Arrays.asList("opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre");
    public static final List<String> varLocal = Arrays.asList("prVar");
    public static final List<String> returnNT = Arrays.asList("prReturn");
    public static final List<String> ifNT = Arrays.asList("prIf");
    public static final List<String> whileNT = Arrays.asList("prWhile");
    public static final List<String> bloque = Arrays.asList("puLlaveAbre");
    public static final List<String> expresion = Arrays.asList("opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre");
    public static final List<String> operadorAsignacion = Arrays.asList("opAsignacion");
    public static final List<String> operadorBinario = Arrays.asList("opOr", "opAnd", "opIgualdad", "opDistinto", "opMenor", "opMayor", "opMenorIgual", "opMayorIgual", "opSuma", "opResta", "opMultiplicacion", "opDivision", "opModulo");
    public static final List<String> operadorUnario = Arrays.asList("opSuma", "opResta", "opNegacion");
    public static final List<String> operando = Arrays.asList("prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre");
    public static final List<String> primitivo = Arrays.asList("prTrue", "prFalse", "intLiteral", "charLiteral", "prNull");
    public static final List<String> referencia = Arrays.asList("prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre");
    public static final List<String> accesoArreglo = Arrays.asList("puCorcheteAbre");
    public static final List<String> argsActuales = Arrays.asList("puParentesisAbre");
    public static final List<String> restoReferencia = Arrays.asList("puPunto", "puCorcheteAbre");
    public static final List<String> llamadaMetodoEstatico = Arrays.asList("idClase");
    public static final List<String> expresionParentizada = Arrays.asList("puParentesisAbre");
    public static final List<String> dimensionesConTamanio = Arrays.asList("puCorcheteAbre");
    public static final List<String> listaExps = Arrays.asList("opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre");


    public static List<String> obtener(String noTerminal) {
        switch (noTerminal) {
            case "clase":
                return Arrays.asList("prClass");
            case "interfaz":
                return Arrays.asList("prInterface");
            case "miembro":
                return Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen", "prStatic", "prVoid", "prPublic");
            case "metodoInterfaz":
                return Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen", "prVoid");
            case "tipo":
                return Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen");
            case "tipoPrimitivo":
                return Arrays.asList("prBoolean", "prChar", "prInt");
            case "tipoReferencia":
                return Arrays.asList("idClase");
            case "listaArgsFormales":
                return Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen");
            case "sentencia":
                return Arrays.asList("puPuntoYComa", "opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre", "prVar", "prReturn", "prIf", "prWhile", "puLlaveAbre");
            case "asignacionYLlamada":
                return Arrays.asList("opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre");
            case "varLocal":
                return Arrays.asList("prVar");
            case "returnNT":
                return Arrays.asList("prReturn");
            case "ifNT":
                return Arrays.asList("prIf");
            case "whileNT":
                return Arrays.asList("prWhile");
            case "bloque":
                return Arrays.asList("puLlaveAbre");
            case "expresion":
                return Arrays.asList("opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre");
            case "operadorAsignacion":
                return Arrays.asList("opAsignacion");
            case "operadorBinario":
                return Arrays.asList("opOr", "opAnd", "opIgualdad", "opDistinto", "opMenor", "opMayor", "opMenorIgual", "opMayorIgual", "opSuma", "opResta", "opMultiplicacion", "opDivision", "opModulo");
            case "operadorUnario":
                return Arrays.asList("opSuma", "opResta", "opNegacion");
            case "operando":
                return Arrays.asList("prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre");
            case "primitivo":
                return Arrays.asList("prTrue", "prFalse", "intLiteral", "charLiteral", "prNull");
            case "referencia":
                return Arrays.asList("prThis", "stringLiteral", "idMetVal", "prNew", "idClase", "puParentesisAbre");
            case "accesoArreglo":
                return Arrays.asList("puCorcheteAbre");
            case "argsActuales":
                return Arrays.asList("puParentesisAbre");
            case "restoReferencia":
                return Arrays.asList("puPunto", "puCorcheteAbre");
//            case "restoIdMetVal":
//                return Arrays.asList("puParentesisAbre");
            case "llamadaMetodoEstatico":
                return Arrays.asList("idClase");
            case "expresionParentizada":
                return Arrays.asList("puParentesisAbre");
//            case "":
//                return Arrays.asList("");
//            case "":
//                return Arrays.asList("");
//            case "":
//                return Arrays.asList("");
//            case "":
//                return Arrays.asList("");
//            case "":
//                return Arrays.asList("");
//            case "":
//                return Arrays.asList("");
//            case "":
//                return Arrays.asList("");
//            case "":
//                return Arrays.asList("");


            default:
                throw new RuntimeException("No existen primeros definidos para: " + noTerminal);


        }
    }
}
