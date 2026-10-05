package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class Atributo extends EntidadDeclarable {
    protected String nombre;
    protected Tipo tipo;

    public Atributo(Token token, Tipo tipo) {
        super(token);
        nombre = token.lexema();
        this.tipo = tipo;
    }
}
