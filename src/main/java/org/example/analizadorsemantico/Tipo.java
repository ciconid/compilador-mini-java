package org.example.analizadorsemantico;

public abstract class Tipo {
    abstract void estaBienDeclarado(ClaseOInterfaz contexto);

    abstract Tipo instanciar(String parametro, Tipo argumento);

    abstract boolean esIgual(Tipo otro);

    public void estaBienUsado(ClaseOInterfaz contexto) {
        estaBienDeclarado(contexto);
    }

    public boolean conformaCon(Tipo destino) {
        return destino instanceof TipoPendiente || esIgual(destino);
    }
}
