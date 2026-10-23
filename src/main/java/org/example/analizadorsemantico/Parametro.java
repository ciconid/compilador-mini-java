package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class Parametro extends EntidadDeclarable {
    protected String nombre;
    protected Tipo tipo;
    protected int posicion;

    public Parametro(Token token, Tipo tipo, int posicion) {
        super(token);
        nombre = token.lexema();
        this.tipo = tipo;
        this.posicion = posicion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
