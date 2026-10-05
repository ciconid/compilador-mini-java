package org.example.analizadorsemantico;

public class TipoVoid extends Tipo {
    void estaBienDeclarado(ClaseOInterfaz contexto) {
    }

    Tipo instanciar(String parametro, Tipo argumento) {
        return this;
    }

    boolean esIgual(Tipo otro) {
        return otro instanceof TipoVoid;
    }
}
