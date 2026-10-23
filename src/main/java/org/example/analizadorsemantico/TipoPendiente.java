package org.example.analizadorsemantico;

public class TipoPendiente extends Tipo {
    void estaBienDeclarado(ClaseOInterfaz contexto) {
    }

    Tipo instanciar(TipoParametro parametro, Tipo argumento) {
        return this;
    }

    boolean esIgual(Tipo otro) {
        return true;
    }

    public boolean conformaCon(Tipo destino) {
        return true;
    }

    public String toString() {
        return "pendiente";
    }
}
