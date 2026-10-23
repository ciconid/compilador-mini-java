package org.example.analizadorsemantico.ast;

import org.example.analizadorsemantico.Tipo;

public abstract class NodoExpresion {
    public abstract Tipo chequear();

    public Tipo chequear(Tipo esperado) {
        return chequear();
    }

    public boolean esAsignable() {
        return false;
    }

    public boolean esAsignacion() {
        return false;
    }

    public boolean esLlamada() {
        return false;
    }

    public boolean tieneBaseParentizada() {
        return false;
    }
}
