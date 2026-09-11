package org.example.analizadorsintactico;

import org.example.analizadorlexico.AnalizadorLexico;
import org.example.analizadorlexico.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings({"ArraysAsListWithZeroOrOneArgument", "StatementWithEmptyBody"})
public class AnalizadorSintactico {
    private final AnalizadorLexico analizadorLexico;
    private Token tokenActual;

    public AnalizadorSintactico(AnalizadorLexico alex) {
        analizadorLexico = alex;
        tokenActual = analizadorLexico.proximoToken();
        inicial();
    }

    void inicial() {
        listaClases();
        match("EOF");
    }

    void listaClases() {
        if (Primeros.clase.contains(tokenActual.token())) {
            clase();
            listaClases();
        } else if (Primeros.interfaz.contains(tokenActual.token())) {
            interfaz();
            listaClases();
        } else {
            // No hacer nada: epsilon
        }
    }

    void clase() {
        match("prClass");
        match("idClase");
        genericidadOpcional();
        herenciaOpcional();
        match("puLlaveAbre");
        listaMiembros();
        match("puLlaveCierra");
    }

    void interfaz() {
        match("prInterface");
        match("idClase");
        genericidadOpcional();
        extensionOpcional();
        match("puLlaveAbre");
        listaMetodosInterfaz();
        match("puLlaveCierra");
    }

    void genericidadOpcional() {
        if (Arrays.asList("opMenor").contains(tokenActual.token())) {
            match("opMenor");
            match("idGen");
            match("opMayor");
        } else {
            // epsilon
        }
    }

    void herenciaOpcional() {
        if (Arrays.asList("prExtends").contains(tokenActual.token())) {
            match("prExtends");
            tipoReferencia();
        } else if (Arrays.asList("prImplements").contains(tokenActual.token())) {
            match("prImplements");
            tipoReferencia();
        } else {
            // epsilon
        }
    }

    void extensionOpcional() {
        if (Arrays.asList("prExtends").contains(tokenActual.token())) {
            match("prExtends");
            tipoReferencia();
        } else {
            // epsilon
        }
    }

    void listaMiembros() {
        if (Primeros.miembro.contains(tokenActual.token())) {
            miembro();
            listaMiembros();
        } else {
            // epsilon
        }
    }

    void listaMetodosInterfaz() {
        if (Primeros.metodoInterfaz.contains(tokenActual.token())) {
            metodoInterfaz();
            listaMetodosInterfaz();
        } else {
            // epsilon
        }
    }

    void miembro() {
        if (Primeros.tipo.contains(tokenActual.token())) {
            tipo();
            match("idMetVal");
            restoMiembro();
        } else if (Arrays.asList("prStatic").contains(tokenActual.token())) {
            match("prStatic");
            tipoMetodo();
            match("idMetVal");
            argsFormales();
            bloque();
        } else if (Arrays.asList("prVoid").contains(tokenActual.token())) {
            match("prVoid");
            match("idMetVal");
            argsFormales();
            bloque();
        } else if (Arrays.asList("prPublic").contains(tokenActual.token())) {
            match("prPublic");
            match("idClase");
            argsFormales();
            bloque();
        } else {
            List<String> tokens = new ArrayList<>(Primeros.tipo);
            tokens.add("prStatic");
            tokens.add("prVoid");
            tokens.add("prPublic");

            String lexemasEsperados = tokens.stream()
                    .map(TokensYLexemas::get)
                    .collect(Collectors.joining(", "));
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), lexemasEsperados);
        }
    }

    void restoMiembro() {
        if (Arrays.asList("puPuntoYComa").contains(tokenActual.token())) {
            match("puPuntoYComa");
        } else if (Arrays.asList("puParentesisAbre").contains(tokenActual.token())) {
            argsFormales();
            bloque();
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), "; o (");
        }
    }


    void atributo() {
        tipo();
        match("idMetVal");
        match("puPuntoYComa");
    }

    void metodo() {
        modificadorOpcional();
        tipoMetodo();
        match("idMetVal");
        argsFormales();
        bloque();
    }

    void metodoInterfaz() {
        tipoMetodo();
        match("idMetVal");
        argsFormales();
        match("puPuntoYComa");
    }

    void constructor() {
        match("prPublic");
        match("idClase");
        argsFormales();
        bloque();
    }

    void modificadorOpcional() {
        if (Arrays.asList("prStatic").contains(tokenActual.token())) {
            match("prStatic");
        } else {
            // epsilon
        }
    }

    void tipoMetodo() {
        if (Primeros.tipo.contains(tokenActual.token())) {
            tipo();
        } else if (Arrays.asList("prVoid").contains(tokenActual.token())) {
            match("prVoid");
        } else {
            List<String> tokens = new ArrayList<>(Primeros.tipo);
            tokens.add("prVoid");

            String lexemasEsperados = tokens.stream()
                    .map(TokensYLexemas::get)
                    .collect(Collectors.joining(", "));
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), lexemasEsperados);
        }
    }

    void tipo() {
        tipoBase();
        dimensionesOpcionales();
    }

    void tipoBase() {
        if (Primeros.tipoPrimitivo.contains(tokenActual.token())) {
            tipoPrimitivo();
        } else if (Primeros.tipoReferencia.contains(tokenActual.token())) {
            tipoReferencia();
        } else if (Arrays.asList("idGen").contains(tokenActual.token())) {
            match("idGen");
        } else {
            List<String> tokens = new ArrayList<>(Primeros.tipoPrimitivo);
            tokens.addAll(Primeros.tipoReferencia);
            tokens.add("idGen");

            String lexemasEsperados = tokens.stream()
                    .map(TokensYLexemas::get)
                    .collect(Collectors.joining(", "));
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), lexemasEsperados);
        }
    }

    void dimensionesOpcionales() {
        if (Arrays.asList("puCorcheteAbre").contains(tokenActual.token())) {
            match("puCorcheteAbre");
            match("puCorcheteCierra");
            dimensionesOpcionales();
        } else {
            // epsilon
        }
    }

    void tipoReferencia() {
        match("idClase");
        tipoGenericoOpcional();
    }

    void tipoPrimitivo() {
        if (Arrays.asList("prBoolean").contains(tokenActual.token())) {
            match("prBoolean");
        } else if (Arrays.asList("prChar").contains(tokenActual.token())) {
            match("prChar");
        } else if (Arrays.asList("prInt").contains(tokenActual.token())) {
            match("prInt");
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), "TIPO-PRIM");
        }
    }

    void tipoGenericoOpcional() {
        if (Arrays.asList("opMenor").contains(tokenActual.token())) {
            match("opMenor");
            instanciadoOParametrico();
            match("opMayor");
        } else {
            // epsilon
        }
    }

    void instanciadoOParametrico() {
        if (Arrays.asList("idGen").contains(tokenActual.token())) {
            match("idGen");
        } else if (Arrays.asList("idClase").contains(tokenActual.token())) {
            match("idClase");
        } else {
            List<String> tokens = new ArrayList<>();
            tokens.add("idGen");
            tokens.add("idClase");

            String lexemasEsperados = tokens.stream()
                    .map(TokensYLexemas::get)
                    .collect(Collectors.joining(", "));
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), lexemasEsperados);
        }
    }

    void argsFormales() {
        match("puParentesisAbre");
        listaArgsFormalesOpcional();
        match("puParentesisCierra");
    }

    void listaArgsFormalesOpcional() {
        if (Primeros.listaArgsFormales.contains(tokenActual.token())) {
            listaArgsFormales();
        } else {
            // epsilon
        }
    }

    void listaArgsFormales() {
        argFormal();
        restoListaArgsFormales();
    }

    void restoListaArgsFormales() {
        if (Arrays.asList("puComa").contains(tokenActual.token())) {
            match("puComa");
            argFormal();
            restoListaArgsFormales();
        } else {
            // epsilon
        }
    }

    void argFormal() {
        tipo();
        match("idMetVal");
    }

    void bloque() {
        match("puLlaveAbre");
        listaSentencias();
        match("puLlaveCierra");
    }

    void listaSentencias() {
        if (Primeros.sentencia.contains(tokenActual.token())) {
            sentencia();
            listaSentencias();
        } else {
            // epsilon
        }
    }

    void sentencia() {
        if (Arrays.asList("puPuntoYComa").contains(tokenActual.token())) {
            match("puPuntoYComa");
        } else if (Primeros.asignacionYLlamada.contains(tokenActual.token())) {
            asignacionYLlamada();
            match("puPuntoYComa");
        } else if (Primeros.varLocal.contains(tokenActual.token())) {
            varLocal();
            match("puPuntoYComa");
        } else if (Primeros.returnNT.contains(tokenActual.token())) {
            returnNT();
            match("puPuntoYComa");
        } else if (Primeros.ifNT.contains(tokenActual.token())) {
            ifNT();
        } else if (Primeros.whileNT.contains(tokenActual.token())) {
            whileNT();
        } else if (Primeros.bloque.contains(tokenActual.token())) {
            bloque();
        } else {
            List<String> tokens = new ArrayList<>();
            tokens.add("puPuntoYComa");
            tokens.addAll(Primeros.asignacionYLlamada);
            tokens.addAll(Primeros.varLocal);
            tokens.addAll(Primeros.returnNT);
            tokens.addAll(Primeros.ifNT);
            tokens.addAll(Primeros.whileNT);
            tokens.addAll(Primeros.bloque);

            String lexemasEsperados = tokens.stream()
                    .map(TokensYLexemas::get)
                    .collect(Collectors.joining(", "));
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), lexemasEsperados);
        }
    }

    void asignacionYLlamada() {
        expresion();
    }

    void varLocal() {
        match("prVar");
        match("idMetVal");
        match("opAsignacion");
        expresionCompuesta();
    }

    void returnNT() {
        match("prReturn");
        expresionOpcional();
    }

    void expresionOpcional() {
        if (Primeros.expresion.contains(tokenActual.token())) {
            expresion();
        } else {
            // epsilon
        }
    }

    void ifNT() {
        ifBase();
        elseNT();
    }

    void ifBase() {
        match("prIf");
        match("puParentesisAbre");
        expresion();
        match("puParentesisCierra");
        sentencia();
    }

    void elseNT() {
        if (Arrays.asList("prElse").contains(tokenActual.token())) {
            match("prElse");
            sentencia();
        } else {
            // epsilon
        }
    }

    void whileNT() {
        match("prWhile");
        match("puParentesisAbre");
        expresion();
        match("puParentesisCierra");
        sentencia();
    }

    void expresion() {
        expresionCompuesta();
        restoExpresion();
    }

    void restoExpresion() {
        if (Primeros.operadorAsignacion.contains(tokenActual.token())) {
            operadorAsignacion();
            expresionCompuesta();
        } else {
            // epsilon
        }
    }

    void operadorAsignacion() {
        match("opAsignacion");
    }

    void expresionCompuesta() {
        expresionBasica();
        restoExpresionCompuesta();
    }

    void restoExpresionCompuesta() {
        if (Primeros.operadorBinario.contains(tokenActual.token())) {
            operadorBinario();
            expresionCompuesta();
        } else {
            // epsilon
        }
    }

    void operadorBinario() {
        if (Arrays.asList("opOr").contains(tokenActual.token())) {
            match("opOr");
        } else if (Arrays.asList("opAnd").contains(tokenActual.token())) {
            match("opAnd");
        } else if (Arrays.asList("opIgualdad").contains(tokenActual.token())) {
            match("opIgualdad");
        } else if (Arrays.asList("opDistinto").contains(tokenActual.token())) {
            match("opDistinto");
        } else if (Arrays.asList("opMenor").contains(tokenActual.token())) {
            match("opMenor");
        } else if (Arrays.asList("opMayor").contains(tokenActual.token())) {
            match("opMayor");
        } else if (Arrays.asList("opMenorIgual").contains(tokenActual.token())) {
            match("opMenorIgual");
        } else if (Arrays.asList("opMayorIgual").contains(tokenActual.token())) {
            match("opMayorIgual");
        } else if (Arrays.asList("opSuma").contains(tokenActual.token())) {
            match("opSuma");
        } else if (Arrays.asList("opResta").contains(tokenActual.token())) {
            match("opResta");
        } else if (Arrays.asList("opMultiplicacion").contains(tokenActual.token())) {
            match("opMultiplicacion");
        } else if (Arrays.asList("opDivision").contains(tokenActual.token())) {
            match("opDivision");
        } else if (Arrays.asList("opModulo").contains(tokenActual.token())) {
            match("opModulo");
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), "OP BIN");
        }
    }

    void expresionBasica() {
        if (Primeros.operadorUnario.contains(tokenActual.token())) {
            operadorUnario();
            operando();
        } else if (Primeros.operando.contains(tokenActual.token())) {
            operando();
        } else {
            List<String> tokens = new ArrayList<>(Primeros.operadorUnario);
            tokens.addAll(Primeros.operando);

            String lexemasEsperados = tokens.stream()
                    .map(TokensYLexemas::get)
                    .collect(Collectors.joining(", "));
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), lexemasEsperados);
        }
    }

    void operadorUnario() {
        if (Arrays.asList("opSuma").contains(tokenActual.token())) {
            match("opSuma");
        } else if (Arrays.asList("opResta").contains(tokenActual.token())) {
            match("opResta");
        } else if (Arrays.asList("opNegacion").contains(tokenActual.token())) {
            match("opNegacion");
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), "OP UN");
        }
    }

    void operando() {
        if (Primeros.primitivo.contains(tokenActual.token())) {
            primitivo();
        } else if (Primeros.referencia.contains(tokenActual.token())) {
            referencia();
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), "OPERANDO");
        }
    }

    void primitivo() {
        if (Arrays.asList("prTrue").contains(tokenActual.token())) {
            match("prTrue");
        } else if (Arrays.asList("prFalse").contains(tokenActual.token())) {
            match("prFalse");
        } else if (Arrays.asList("intLiteral").contains(tokenActual.token())) {
            match("intLiteral");
        } else if (Arrays.asList("charLiteral").contains(tokenActual.token())) {
            match("charLiteral");
        } else if (Arrays.asList("prNull").contains(tokenActual.token())) {
            match("prNull");
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), "PRIMITIVO");
        }
    }

    void referencia() {
        primario();
        restoReferencia();
    }

    void restoReferencia() {
        if (Arrays.asList("puPunto").contains(tokenActual.token())) {
            match("puPunto");
            match("idMetVal");
            argsActualesOpcionales();
            restoReferencia();
        } else if (Primeros.accesoArreglo.contains(tokenActual.token())) {
            accesoArreglo();
            restoReferencia();
        } else {
            //epsilon
        }
    }

    void argsActualesOpcionales() {
        if (Primeros.argsActuales.contains(tokenActual.token())) {
            argsActuales();
        } else {
            //epsilon
        }
    }

    void primario() {
        if (Arrays.asList("prThis").contains(tokenActual.token())) {
            match("prThis");
        } else if (Arrays.asList("stringLiteral").contains(tokenActual.token())) {
            match("stringLiteral");
        } else if (Arrays.asList("idMetVal").contains(tokenActual.token())) {
            match("idMetVal");
            restoIdMetVal();
        } else if (Arrays.asList("prNew").contains(tokenActual.token())) {
            match("prNew");
            restoNew();
        } else if (Primeros.llamadaMetodoEstatico.contains(tokenActual.token())) {
            llamadaMetodoEstatico();
        } else if (Primeros.expresionParentizada.contains(tokenActual.token())) {
            expresionParentizada();
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), "PRIMARIO");
        }
    }

    void restoIdMetVal() {
        if (Primeros.argsActuales.contains(tokenActual.token())) {
            argsActuales();
        } else {
            // epsilon
        }
    }

    void restoNew() {
        if (Primeros.tipoPrimitivo.contains(tokenActual.token())) {
            tipoPrimitivo();
            dimensionesConTamanio();
        } else if (Arrays.asList("idGen").contains(tokenActual.token())) {
            match("idGen");
            dimensionesConTamanio();
        } else if (Primeros.tipoReferencia.contains(tokenActual.token())) {
            tipoReferencia();
            restoTipoReferencia();
        } else {
            List<String> tokens = new ArrayList<>(Primeros.tipoPrimitivo);
            tokens.add("idGen");
            tokens.addAll(Primeros.tipoReferencia);

            String lexemasEsperados = tokens.stream()
                    .map(TokensYLexemas::get)
                    .collect(Collectors.joining(", "));
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), lexemasEsperados);
        }
    }

    void restoTipoReferencia() {
        if (Primeros.dimensionesConTamanio.contains(tokenActual.token())) {
            dimensionesConTamanio();
        } else if (Primeros.argsActuales.contains(tokenActual.token())) {
            argsActuales();
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), "RESTO TIPO REF");
        }
    }

    void expresionParentizada() {
        match("puParentesisAbre");
        expresion();
        match("puParentesisCierra");
    }

    void llamadaMetodoEstatico() {
        match("idClase");
        match("puPunto");
        match("idMetVal");
        argsActuales();
    }

    void dimensionesConTamanio() {
        match("puCorcheteAbre");
        expresion();
        match("puCorcheteCierra");
        restoDimensionesConTamanio();
    }

    void restoDimensionesConTamanio() {
        if (Primeros.dimensionesConTamanio.contains(tokenActual.token())) {
            dimensionesConTamanio();
        } else {
            // epsilon
        }
    }

    void argsActuales() {
        match("puParentesisAbre");
        listaExpsOpcional();
        match("puParentesisCierra");
    }

    void listaExpsOpcional() {
        if (Primeros.listaExps.contains(tokenActual.token())) {
            listaExps();
        } else {
            // epsilon
        }
    }

    void listaExps() {
        expresion();
        restoListaExps();
    }

    void restoListaExps() {
        if (Arrays.asList("puComa").contains(tokenActual.token())) {
            match("puComa");
            listaExps();
        } else {
            // epsilon
        }
    }

    void accesoArreglo() {
        match("puCorcheteAbre");
        expresion();
        match("puCorcheteCierra");
    }


    void match(String nombreToken) {
        if (nombreToken.equals(tokenActual.token())) {
            tokenActual = analizadorLexico.proximoToken();
        } else {
//            System.out.println("DEBUG: Se esperaba " + nombreToken + " pero vino " + tokenActual.token());
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea(), TokensYLexemas.get(nombreToken));
        }
    }
}
