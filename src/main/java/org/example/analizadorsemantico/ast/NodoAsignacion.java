package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.ErrorSemantico;
import org.example.analizadorsemantico.Tipo;

public class NodoAsignacion extends NodoExpresion {
    private final Token tokenIgual;
    private final NodoExpresion ladoIzq;
    private final NodoExpresion ladoDer;

    public NodoAsignacion(Token tokenIgual, NodoExpresion ladoIzq, NodoExpresion ladoDer) {
        this.tokenIgual = tokenIgual;
        this.ladoIzq = ladoIzq;
        this.ladoDer = ladoDer;
    }

    public Tipo chequear() {
        Tipo tipoIzq = ladoIzq.chequear();
        Tipo tipoDer = ladoDer.chequear(tipoIzq);
        if (!ladoIzq.esAsignable()) {
            throw new ErrorSemantico(tokenIgual, "El lado izquierdo de la asignacion no es asignable");
        }
        if (!tipoDer.conformaCon(tipoIzq)) {
            throw new ErrorSemantico(tokenIgual, "Tipos incompatibles en la asignacion: " + tipoDer
                    + " no conforma con " + tipoIzq);
        }
        return tipoIzq;
    }

    public boolean esAsignacion() {
        return true;
    }
}
