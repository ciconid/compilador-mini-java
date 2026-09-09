package org.example.analizadorsintactico;

import org.example.analizadorlexico.AnalizadorLexico;
import org.example.analizadorlexico.Token;

public class AnalizadorSintactico {
    private AnalizadorLexico analizadorLexico;
    private Token tokenActual;

    public AnalizadorSintactico(AnalizadorLexico alex){
        analizadorLexico = alex;
        tokenActual = analizadorLexico.proximoToken();
        inicial();
    }

    void inicial() {

    }



    void match(String nombreToken) {
        if (nombreToken.equals(tokenActual.token())) {
            tokenActual = analizadorLexico.proximoToken();
        } else {
            throw new ErrorSintactico(tokenActual.lexema(), tokenActual.nroDeLinea());
        }
    }
}
