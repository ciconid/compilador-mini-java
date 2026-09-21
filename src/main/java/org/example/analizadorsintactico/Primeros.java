package org.example.analizadorsintactico;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public class Primeros {

    public static final List<String> clase = Arrays.asList("prClass");
    public static final List<String> interfaz = Arrays.asList("prInterface");
    public static final List<String> miembro = Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen", "prStatic", "prVoid", "prPublic", "prPrivate");
    public static final List<String> metodoInterfaz = Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen", "prVoid");
    public static final List<String> tipo = Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen");
    public static final List<String> atributoOMetodo = Arrays.asList("prBoolean", "prChar", "prInt", "idGen");
    public static final List<String> atributoOMetodoOConstructor = Arrays.asList("idClase");
    public static final List<String> atributo = Arrays.asList("puPuntoYComa", "opAsignacion");

    public static final List<String> argsFormales = Arrays.asList("puParentesisAbre");
    public static final List<String> metodo = Primeros.argsFormales;
    public static final List<String> tipoPrimitivo = Arrays.asList("prBoolean", "prChar", "prInt");
    public static final List<String> tipoReferencia = Arrays.asList("idClase");
    public static final List<String> listaArgsFormales = Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen");
    public static final List<String> sentencia = Arrays.asList("puPuntoYComa", "opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVar", "prNew", "idClase", "puParentesisAbre", "prVar", "prReturn", "prIf", "prWhile", "puLlaveAbre");
    public static final List<String> asignacionYLlamada = Arrays.asList("opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVar", "prNew", "idClase", "puParentesisAbre");
    public static final List<String> varLocal = Arrays.asList("prVar");
    public static final List<String> returnNT = Arrays.asList("prReturn");
    public static final List<String> ifNT = Arrays.asList("prIf");
    public static final List<String> whileNT = Arrays.asList("prWhile");
    public static final List<String> bloque = Arrays.asList("puLlaveAbre");
    public static final List<String> expresion = Arrays.asList("opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVar", "prNew", "idClase", "puParentesisAbre");
    public static final List<String> operadorAsignacion = Arrays.asList("opAsignacion");
    public static final List<String> operadorBinario = Arrays.asList("opOr", "opAnd", "opIgualdad", "opDistinto", "opMenor", "opMayor", "opMenorIgual", "opMayorIgual", "opSuma", "opResta", "opMultiplicacion", "opDivision", "opModulo");
    public static final List<String> operadorUnario = Arrays.asList("opSuma", "opResta", "opNegacion");
    public static final List<String> operadorUnarioPosfijo = Arrays.asList("opIncremento", "opDecremento");
    public static final List<String> operando = Arrays.asList("prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVar", "prNew", "idClase", "puParentesisAbre");
    public static final List<String> primitivo = Arrays.asList("prTrue", "prFalse", "intLiteral", "charLiteral", "prNull");
    public static final List<String> referencia = Arrays.asList("prThis", "stringLiteral", "idMetVar", "prNew", "idClase", "puParentesisAbre");
    public static final List<String> accesoArreglo = Arrays.asList("puCorcheteAbre");
    public static final List<String> argsActuales = Arrays.asList("puParentesisAbre");
    public static final List<String> restoReferencia = Arrays.asList("puPunto", "puCorcheteAbre");
    public static final List<String> llamadaMetodoEstatico = Arrays.asList("idClase");
    public static final List<String> expresionParentizada = Arrays.asList("puParentesisAbre");

    public static final List<String> restoTernario = Arrays.asList("puInterrogacion");
    public static final List<String> dimensionesConTamanio = Primeros.expresion;
    public static final List<String> dimensionesSinTamanio = Arrays.asList("puCorcheteCierra");
    public static final List<String> listaExps = Arrays.asList("opSuma", "opResta", "opNegacion", "prTrue", "prFalse", "intLiteral", "charLiteral", "prNull", "prThis", "stringLiteral", "idMetVar", "prNew", "idClase", "puParentesisAbre");
    public static final List<String> llaveAbre = Arrays.asList("puLlaveAbre");
    public static final List<String> coma = Arrays.asList("puComa");
    public static final List<String> corcheteAbre = Arrays.asList("puCorcheteAbre");
    public static final List<String> dimensiones = Arrays.asList("puCorcheteAbre");
    public static final List<String> prPublic = Arrays.asList("prPublic");
    public static final List<String> prPrivate = Arrays.asList("prPrivate");
    public static final List<String> constructor = Primeros.argsFormales;

    public static final List<String> restoAtrMetCon = Arrays.asList("idMetVar", "opMenor", "puCorcheteAbre");
}
