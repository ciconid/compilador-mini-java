package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class TipoParametro extends Tipo {
    protected Token token;
    protected String nombre;

    public TipoParametro(Token token) {
        this.token = token;
        nombre = token.lexema();
    }

    void estaBienDeclarado(ClaseOInterfaz contexto) {
        if (!nombre.equals(contexto.parametroGenericoOpcional)) {
            throw new ErrorSemantico(token, "El parametro de tipo " + nombre + " no esta declarado en "
                    + contexto.nombre);
        }
    }

    Tipo instanciar(String parametro, Tipo argumento) {
        return nombre.equals(parametro) ? argumento : this;
    }

    boolean esIgual(Tipo otro) {
        return otro instanceof TipoParametro tipoParametro && tipoParametro.nombre.equals(nombre);
    }
}
