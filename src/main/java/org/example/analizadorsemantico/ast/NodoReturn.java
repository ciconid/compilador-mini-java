package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

public class NodoReturn extends NodoSentencia {
    private final Token tokenReturn;
    private final NodoExpresion expresion;

    public NodoReturn(Token tokenReturn, NodoExpresion expresion) {
        this.tokenReturn = tokenReturn;
        this.expresion = expresion;
    }

    public void chequear() {
        Tipo tipoRetorno = TablaDeSimbolos.ts.getUnidadActual().getTipoRetorno();
        if (expresion == null) {
            if (!(tipoRetorno instanceof TipoVoid)) {
                throw new ErrorSemantico(tokenReturn, "El return debe devolver un valor de tipo " + tipoRetorno);
            }
            return;
        }
        Tipo tipoExpresion = expresion.chequear(tipoRetorno);
        if (tipoRetorno instanceof TipoVoid) {
            throw new ErrorSemantico(tokenReturn, "Un metodo void o un constructor no puede retornar un valor");
        }
        if (!tipoExpresion.conformaCon(tipoRetorno)) {
            throw new ErrorSemantico(tokenReturn, "El tipo retornado " + tipoExpresion
                    + " no conforma con el tipo de retorno " + tipoRetorno);
        }
    }
}
