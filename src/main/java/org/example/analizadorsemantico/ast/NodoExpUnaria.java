package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

public class NodoExpUnaria extends NodoExpresion {
    private final Token operador;
    private final NodoExpresion operando;

    public NodoExpUnaria(Token operador, NodoExpresion operando) {
        this.operador = operador;
        this.operando = operando;
    }

    public Tipo chequear() {
        Tipo tipoOperando = operando.chequear();
        Tipo tipoEsperado = operador.token().equals("opNegacion") ? new TipoBoolean() : new TipoInt();
        if (!tipoOperando.conformaCon(tipoEsperado)) {
            throw new ErrorSemantico(operador, "El operador " + operador.lexema() + " requiere un operando de tipo "
                    + tipoEsperado + ", pero es de tipo " + tipoOperando);
        }
        return tipoEsperado;
    }
}
