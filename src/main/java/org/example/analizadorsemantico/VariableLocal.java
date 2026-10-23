package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class VariableLocal extends EntidadDeclarable {
    protected String nombre;
    protected Tipo tipo;

    public VariableLocal(Token token, Tipo tipo) {
        super(token);
        nombre = token.lexema();
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
