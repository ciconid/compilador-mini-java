package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

import java.util.List;

public class NodoInicializadorArreglo extends NodoExpresion {
    private final Token tokenLlave;
    private final List<NodoExpresion> elementos;

    public NodoInicializadorArreglo(Token tokenLlave, List<NodoExpresion> elementos) {
        this.tokenLlave = tokenLlave;
        this.elementos = elementos;
    }

    public Tipo chequear() {
        return chequear(null);
    }

    public Tipo chequear(Tipo esperado) {
        if (!(esperado instanceof TipoArreglo arreglo)) {
            throw new ErrorSemantico(tokenLlave, "Un inicializador {...} solo puede usarse donde se espera un arreglo, "
                    + "pero se espera " + esperado);
        }
        Tipo tipoComponente = arreglo.getTipoComponente();
        for (NodoExpresion elemento : elementos) {
            Tipo tipoElemento = elemento.chequear(tipoComponente);
            if (!tipoElemento.conformaCon(tipoComponente)) {
                throw new ErrorSemantico(tokenLlave, "Un elemento de tipo " + tipoElemento
                        + " no conforma con el tipo de los elementos de " + arreglo + ", " + tipoComponente);
            }
        }
        return arreglo;
    }
}
