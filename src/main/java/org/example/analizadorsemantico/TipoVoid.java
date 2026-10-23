package org.example.analizadorsemantico;

public class TipoVoid extends Tipo {
    void estaBienDeclarado(ClaseOInterfaz contexto) {
    }

    Tipo instanciar(TipoParametro parametro, Tipo argumento) {
        return this;
    }

    boolean esIgual(Tipo otro) {
        return otro instanceof TipoVoid;
    }

    public boolean conformaCon(Tipo destino) {
        return false;
    }

    public String toString() {
        return "void";
    }
}
