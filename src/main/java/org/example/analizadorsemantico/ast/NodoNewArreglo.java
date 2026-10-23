package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

import java.util.List;

public class NodoNewArreglo extends NodoExpresion {
    private final Tipo tipoBase;
    private final List<Token> corchetes;
    private final List<NodoExpresion> tamanios;

    public NodoNewArreglo(Tipo tipoBase, List<Token> corchetes, List<NodoExpresion> tamanios) {
        this.tipoBase = tipoBase;
        this.corchetes = corchetes;
        this.tamanios = tamanios;
    }

    public Tipo chequear() {
        tipoBase.estaBienUsado(TablaDeSimbolos.ts.getClaseActual());
        for (int i = 0; i < tamanios.size(); i++) {
            Tipo tipoTamanio = tamanios.get(i).chequear();
            if (!tipoTamanio.conformaCon(new TipoInt())) {
                throw new ErrorSemantico(corchetes.get(i), "El tamanio de un arreglo tiene que ser int, pero es "
                        + tipoTamanio);
            }
        }
        return new TipoArreglo(tipoBase, tamanios.size());
    }
}
