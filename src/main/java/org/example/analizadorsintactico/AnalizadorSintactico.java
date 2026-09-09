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
        match("$");
    }

    void listaClases() {
        if (Arrays.asList("class").contains(tokenActual.token())) {
            clase();
            listaClases();
        } else if (Arrays.asList("interface").contains(tokenActual.token())) {
            interfaz();
            listaClases();
        } else {
            // No hacer nada: epsilon
        }
    }

    void clase() {
        match("class");
        match("idClase");
        genericidadOpcional();
        herenciaOpcional();
        listaMiembros();
    }

    void interfaz() {
        match("interface");
        match("idClase");
        match("<");
        genericidadOpcional();
        match(">");
        extensionOpcional();
        match("{");
        listaMetodosInterfaz();
        match("}");
    }

    void genericidadOpcional() {
        if (Arrays.asList("<").contains(tokenActual.token())) {
            match("<");
            match("idGen");
            match(">");
        } else {
            // epsilon
        }
    }

    void herenciaOpcional() {
        if (Arrays.asList("extends").contains(tokenActual.token())) {
            match("extends");
            tipoReferencia();
        } else if (Arrays.asList("implements").contains(tokenActual.token())) {
            match("implements");
            tipoReferencia();
        } else {
            // epsilon
        }
    }

    void extensionOpcional() {
        if (Arrays.asList("extends").contains(tokenActual.token())) {
            match("extends");
            tipoReferencia();
        } else {
            // epsilon
        }
    }

    void listaMiembros() {
        if (Arrays.asList("boolean", "char", "int", "idClase", "idGen", "static", "void", "public").contains(tokenActual.token())) {
            miembro();
            listaMiembros();
        } else {
            // epsilon
        }
    }

    void listaMetodosInterfaz() {
        if (Arrays.asList("boolean", "char", "int", "idClase", "idGen", "void").contains(tokenActual.token())) {
            metodoInterfaz();
            listaMetodosInterfaz();
        } else {
            // epsilon
        }
    }

    void miembro() {
        if (Arrays.asList("boolean", "char", "int", "idClase", "idGen").contains(tokenActual.token())) {
            tipo();
            match("idMetVar");
            restoMiembro();
        } else if (Arrays.asList("static").contains(tokenActual.token())) {
            match("static");
            tipoMetodo();
            match("idMetVar");
            argsFormales();
            bloque();
        } else if (Arrays.asList("void").contains(tokenActual.token())) {
            match("void");
            match("idMetVar");
            argsFormales();
            bloque();
        } else if (Arrays.asList("public").contains(tokenActual.token())) {
            match("public");
            match("idClase");
            argsFormales();
            bloque();
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea());
        }
    }

    void restoMiembro() {
        if (Arrays.asList(";").contains(tokenActual.token())) {
            match("puPuntoYComa");
        } else if (Arrays.asList("(").contains(tokenActual.token())) {
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
    }

    void metodo() {
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
