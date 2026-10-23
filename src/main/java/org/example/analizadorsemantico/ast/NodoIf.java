package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.ErrorSemantico;
import org.example.analizadorsemantico.Tipo;
import org.example.analizadorsemantico.TipoBoolean;

public class NodoIf extends NodoSentencia {
    private final Token tokenIf;
    private final NodoExpresion condicion;
    private final NodoSentencia sentenciaThen;
    private NodoSentencia sentenciaElse;

    public NodoIf(Token tokenIf, NodoExpresion condicion, NodoSentencia sentenciaThen) {
        this.tokenIf = tokenIf;
        this.condicion = condicion;
        this.sentenciaThen = sentenciaThen;
    }

    public void setSentenciaElse(NodoSentencia sentenciaElse) {
        this.sentenciaElse = sentenciaElse;
    }

    public void chequear() {
        Tipo tipoCondicion = condicion.chequear();
        if (!tipoCondicion.conformaCon(new TipoBoolean())) {
            throw new ErrorSemantico(tokenIf, "La condicion del if debe ser de tipo boolean, pero es de tipo "
                    + tipoCondicion);
        }
        sentenciaThen.chequear();
        if (sentenciaElse != null) {
            sentenciaElse.chequear();
        }
    }
}
