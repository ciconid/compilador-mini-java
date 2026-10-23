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

    public void estaBienUsado(ClaseOInterfaz contexto) {
        tipoBase.estaBienUsado(contexto);
    }

    Tipo instanciar(TipoParametro parametro, Tipo argumento) {
        return new TipoArreglo(tipoBase.instanciar(parametro, argumento), dimensiones);
    }

    TipoParametro getParametroUsado() {
        return tipoBase.getParametroUsado();
    }

    boolean esIgual(Tipo otro) {
        return otro instanceof TipoArreglo arreglo
                && arreglo.dimensiones == dimensiones
                && tipoBase.esIgual(arreglo.tipoBase);
    }

    public Tipo getTipoComponente() {
        return dimensiones == 1 ? tipoBase : new TipoArreglo(tipoBase, dimensiones - 1);
    }

    public boolean conformaCon(Tipo destino) {
        return super.conformaCon(destino) || destino instanceof TipoReferencia referencia && referencia.esObject();
    }

    public String toString() {
        return tipoBase + "[]".repeat(dimensiones);
    }
}
