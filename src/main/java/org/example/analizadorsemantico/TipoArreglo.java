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

    Tipo instanciar(String parametro, Tipo argumento) {
        return new TipoArreglo(tipoBase.instanciar(parametro, argumento), dimensiones);
    }

    boolean esIgual(Tipo otro) {
        return otro instanceof TipoArreglo arreglo
                && arreglo.dimensiones == dimensiones
                && tipoBase.esIgual(arreglo.tipoBase);
    }
}
