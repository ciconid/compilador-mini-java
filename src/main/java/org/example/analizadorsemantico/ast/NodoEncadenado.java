package org.example.analizadorsemantico.ast;

public abstract class NodoEncadenado extends NodoExpresion {
    protected final NodoExpresion receptor;

    protected NodoEncadenado(NodoExpresion receptor) {
        this.receptor = receptor;
    }

    public boolean tieneBaseParentizada() {
        return receptor.tieneBaseParentizada();
    }
}
