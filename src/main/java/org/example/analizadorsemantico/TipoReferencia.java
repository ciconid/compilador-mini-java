package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class TipoReferencia extends Tipo {
    protected Token token;
    protected String nombre;
    protected Tipo argumentoGenerico;

    public TipoReferencia(Token token, Tipo argumentoGenerico) {
        this.token = token;
        nombre = token.lexema();
        this.argumentoGenerico = argumentoGenerico;
    }
}
