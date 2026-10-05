package org.example.analizadorsemantico;

public class TipoArreglo extends Tipo {
    protected Tipo tipoBase;
    protected int dimensiones;

    public TipoArreglo(Tipo tipoBase, int dimensiones) {
        this.tipoBase = tipoBase;
        this.dimensiones = dimensiones;
    }

    void estaBienDeclarado(ClaseOInterfaz contexto) {
        tipoBase.estaBienDeclarado(contexto);
    }
}
