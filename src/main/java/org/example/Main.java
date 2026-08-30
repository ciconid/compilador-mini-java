package org.example;

import org.example.analizadorlexico.AnalizadorLexico;
import org.example.analizadorlexico.ErrorLexico;
import org.example.analizadorlexico.Token;
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

        AnalizadorLexico analizadorLexico = new AnalizadorLexico(sourceManager);
        try {
            Token token = analizadorLexico.proximoToken();
            while (!token.token().equals("EOF")) {
                System.out.println(token);

                token = analizadorLexico.proximoToken();
            }
            System.out.println(token);
        } catch (ErrorLexico e) {
            System.out.println("[Error:" + e.getLexema() + "|" + e.getNroLinea() + "]");
            huboErrores = true;
        }


        try {
            sourceManager.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!huboErrores) {
            System.out.println("[SinErrores]");
        }

    }
}