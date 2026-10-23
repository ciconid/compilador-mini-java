package org.example.analizadorsemantico;

public abstract class Tipo {
    abstract void estaBienDeclarado(ClaseOInterfaz contexto);

    abstract Tipo instanciar(TipoParametro parametro, Tipo argumento);

    abstract boolean esIgual(Tipo otro);

    public void estaBienUsado(ClaseOInterfaz contexto) {
        estaBienDeclarado(contexto);
    }

    TipoParametro getParametroUsado() {
        return null;
    }

    public void chequearSinParametroDeTipo() {
        TipoParametro parametro = getParametroUsado();
        if (parametro != null) {
            throw new ErrorSemantico(parametro.token, "El parametro de tipo " + parametro.nombre
                    + " no puede usarse en un contexto estatico");
        }
    }

    public boolean conformaCon(Tipo destino) {
        return destino instanceof TipoPendiente || esIgual(destino);
    }
}
