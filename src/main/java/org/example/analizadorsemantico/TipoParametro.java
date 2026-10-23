package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class TipoParametro extends Tipo {
    protected Token token;
    protected String nombre;
    protected String origen;

    public TipoParametro(Token token, String origen) {
        this.token = token;
        nombre = token.lexema();
        this.origen = origen;
    }

    void estaBienDeclarado(ClaseOInterfaz contexto) {
        if (!nombre.equals(contexto.parametroGenericoOpcional)) {
            throw new ErrorSemantico(token, "El parametro de tipo " + nombre + " no esta declarado en "
                    + contexto.nombre);
        }
    }

    Tipo instanciar(TipoParametro parametro, Tipo argumento) {
        return esIgual(parametro) ? argumento : this;
    }

    boolean esIgual(Tipo otro) {
        return otro instanceof TipoParametro tipoParametro && tipoParametro.nombre.equals(nombre)
                && tipoParametro.origen.equals(origen);
    }

    TipoParametro getParametroUsado() {
        return this;
    }

    public String toString() {
        return nombre;
    }
}
