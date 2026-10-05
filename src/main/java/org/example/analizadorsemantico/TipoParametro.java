package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class TipoParametro extends Tipo {
    protected Token token;
    protected String nombre;

    public TipoParametro(Token token) {
        this.token = token;
        nombre = token.lexema();
    }
}
