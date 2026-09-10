package org.example.analizadorsintactico;

import org.example.analizadorlexico.AnalizadorLexico;
import org.example.analizadorlexico.Token;

import java.util.Arrays;

public class AnalizadorSintactico {
    private AnalizadorLexico analizadorLexico;
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
        if (Primeros.obtener("clase").contains(tokenActual.token())) {
            clase();
            listaClases();
        } else if (Primeros.obtener("interfaz").contains(tokenActual.token())) {
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
        listaMiembros();
    }

    void interfaz() {
        match("prInterface");
        match("idClase");
        match("opMenor");
        genericidadOpcional();
        match("opMayor");
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
        if (Arrays.asList("prEextends").contains(tokenActual.token())) {
            match("prExtends");
            tipoReferencia();
        } else {
            // epsilon
        }
    }

    void listaMiembros() {
        if (Primeros.obtener("miembro").contains(tokenActual.token())) {
            miembro();
            listaMiembros();
        } else {
            // epsilon
        }
    }

    void listaMetodosInterfaz() {
        if (Primeros.obtener("metodoInterfaz").contains(tokenActual.token())) {
            metodoInterfaz();
            listaMetodosInterfaz();
        } else {
            // epsilon
        }
    }

    void miembro() {
        if (Primeros.obtener("tipo").contains(tokenActual.token())) {
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
        } else if (Arrays.asList("PrPublic").contains(tokenActual.token())) {
            match("prPublic");
            match("idClase");
            argsFormales();
            bloque();
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea());
        }
    }

    void restoMiembro() {
        if (Arrays.asList("puPuntoYComa").contains(tokenActual.token())) {
            match("puPuntoYComa");
        } else if (Arrays.asList("puParentesisAbre").contains(tokenActual.token())) {
            argsFormales();
            bloque();
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea());
        }
    }

    // CON EPSILON
    //if (Arrays.asList("extends").contains(tokenActual.token())) {
    //
    //    } else if (Arrays.asList("implements").contains(tokenActual.token())) {
    //
    //    } else {
    //        // epsilon
    //    }

    // SIN EPSILON
    //if (Arrays.asList("extends").contains(tokenActual.token())) {
    //
    //    } else if (Arrays.asList("implements").contains(tokenActual.token())) {
    //
    //    } else {
    //      throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea());
    //    }
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
    }

    void constructor() {
    }

    void modificadorOpcional() {
    }

    void tipoMetodo() {
    }

    void tipo() {
    }

    void tipoBase() {
    }

    void dimensionesOpcionales() {
    }

    void tipoReferencia() {
    }

    void tipoPrimitivo() {
    }

    void tipoGenericoOpcional() {
    }

    void instanciadoOParametrico() {
    }

    void argsFormales() {
    }

    void listaArgsFormalesOpcional() {
    }

    void listaArgsFormales() {
    }

    void restoListaArgsFormales() {
    }

    void argFormal() {
    }

    void bloque() {
    }

    void listaSentencias() {
    }

    void sentencia() {
    }

    void asignacionYLlamada() {
    }

    void varLocal() {
    }

    void RetornoReturn() {
    }

    void expresionOpcional() {
    }

    void condicionalIf() {
    }

    void loopWhile() {
    }

    void expresion() {
    }

    void operadorAsignacion() {
    }

    void expresionCompuesta() {
    }

    void operadorBinario() {
    }

    void expresionBasica() {
    }

    void operadorUnario() {
    }

    void operando() {
    }

    void primitivo() {
    }

    void referencia() {
    }

    void restoReferencia() {
    }

    void restoReferenciaEncadenadas() {
    }

    void primario() {
    }

    void restoIdMetVar() {
    }

    void restoNew() {
    }

    void restoTipoReferencia() {
    }

    void expresionParentizada() {
    }

    void llamadaMetodoEstatico() {
    }

    void dimensionesConTamanio() {
    }

    void argsActuales() {
    }

    void listaExpsOpcional() {
    }

    void listaExps() {
    }

    void accesoArreglo() {
    }


    void match(String nombreToken) {
        if (nombreToken.equals(tokenActual.lexema())) {
            tokenActual = analizadorLexico.proximoToken();
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea());
        }
    }
}
