package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public abstract class EntidadDeclarable {
    protected Token token;

    public EntidadDeclarable(Token token) {
        this.token = token;
    }
}
