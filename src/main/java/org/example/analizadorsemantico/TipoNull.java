package org.example.analizadorsemantico;

public class TipoNull extends Tipo {
    void estaBienDeclarado(ClaseOInterfaz contexto) {
    }

    Tipo instanciar(String parametro, Tipo argumento) {
        return this;
    }

    boolean esIgual(Tipo otro) {
        return otro instanceof TipoNull;
    }

    public boolean conformaCon(Tipo destino) {
        return super.conformaCon(destino)
                || destino instanceof TipoReferencia
                || destino instanceof TipoArreglo
                || destino instanceof TipoParametro;
    }

    public String toString() {
        return "null";
    }
}
