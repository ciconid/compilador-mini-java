package org.example.analizadorsemantico;

public abstract class TipoPrimitivo extends Tipo {
    void estaBienDeclarado(ClaseOInterfaz contexto) {
    }

    Tipo instanciar(TipoParametro parametro, Tipo argumento) {
        return this;
    }

    boolean esIgual(Tipo otro) {
        return otro != null && otro.getClass() == getClass();
    }
}
