package org.example.analizadorsemantico.ast;

import org.example.analizadorsemantico.Tipo;

public class NodoParentizada extends NodoExpresion {
    private final NodoExpresion expresion;

    public NodoParentizada(NodoExpresion expresion) {
        this.expresion = expresion;
    }

    public Tipo chequear() {
        return expresion.chequear();
    }

    public Tipo chequear(Tipo esperado) {
        return expresion.chequear(esperado);
    }
}
