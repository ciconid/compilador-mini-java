package org.example;

import org.example.analizadorlexico.AnalizadorLexico;
import org.example.analizadorlexico.ErrorLexico;
import org.example.analizadorsemantico.ErrorSemantico;
import org.example.analizadorsemantico.TablaDeSimbolos;
import org.example.analizadorsintactico.AnalizadorSintactico;
import org.example.analizadorsintactico.ErrorSintactico;
import org.example.sourcemanager.SourceManagerImpl;
import org.example.sourcemanager.SourceManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        boolean huboErrores = false;

        if (args.length != 1) {
            System.out.println("Uso: java -jar Compilador.jar <archivo.java>");
            System.exit(1);
        }
        String filePath = args[0];

        SourceManager sourceManager = new SourceManagerImpl();
        try {
            sourceManager.open(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        TablaDeSimbolos.ts = new TablaDeSimbolos();

        AnalizadorLexico analizadorLexico = new AnalizadorLexico(sourceManager);
        try {
            AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico(analizadorLexico);
            TablaDeSimbolos.ts.chequeoDeclaraciones();
        } catch (ErrorSintactico e) {
            System.out.println("Error Sintactico en linea " + e.getNroLinea() + ": Se esperaba " + e.getLexemasEsperados() + ", pero se encontro \"" + e.getLexema() + "\"");
            System.out.println();

            System.out.println("[Error:" + e.getLexema() + "|" + e.getNroLinea() + "]");
            huboErrores = true;
        } catch (ErrorLexico e) {
            System.out.println("Error Lexico");
            System.out.println("[Error:" + e.getLexema() + "|" + e.getNroLinea() + "]");
            huboErrores = true;
        } catch (ErrorSemantico e) {
            System.out.println("Error Semantico en linea " + e.getNroLinea() + ": " + e.getMessage());
            System.out.println();

            System.out.println("[Error:" + e.getLexema() + "|" + e.getNroLinea() + "]");
            huboErrores = true;
        }

        try {
            sourceManager.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!huboErrores) {
            System.out.println("Compilacion Exitosa");
            System.out.println();
            System.out.println("[SinErrores]");
        }

    }
}