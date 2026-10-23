package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.ErrorSemantico;

public class NodoSentenciaExpresion extends NodoSentencia {
    private final NodoExpresion expresion;
    private final Token tokenPuntoYComa;

    public NodoSentenciaExpresion(NodoExpresion expresion, Token tokenPuntoYComa) {
        this.expresion = expresion;
        this.tokenPuntoYComa = tokenPuntoYComa;
    }

    public void chequear() {
        expresion.chequear();
        if (!expresion.esAsignacion() && !expresion.esLlamada()) {
            throw new ErrorSemantico(tokenPuntoYComa, "La expresion no es una asignacion ni una llamada");
        }
    }
}
