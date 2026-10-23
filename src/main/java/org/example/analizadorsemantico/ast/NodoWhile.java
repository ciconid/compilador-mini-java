package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.ErrorSemantico;
import org.example.analizadorsemantico.Tipo;
import org.example.analizadorsemantico.TipoBoolean;

public class NodoWhile extends NodoSentencia {
    private final Token tokenWhile;
    private final NodoExpresion condicion;
    private final NodoSentencia cuerpo;

    public NodoWhile(Token tokenWhile, NodoExpresion condicion, NodoSentencia cuerpo) {
        this.tokenWhile = tokenWhile;
        this.condicion = condicion;
        this.cuerpo = cuerpo;
    }

    public void chequear() {
        Tipo tipoCondicion = condicion.chequear();
        if (!tipoCondicion.conformaCon(new TipoBoolean())) {
            throw new ErrorSemantico(tokenWhile, "La condicion del while debe ser de tipo boolean, pero es de tipo "
                    + tipoCondicion);
        }
        cuerpo.chequearComoCuerpo();
    }
}
