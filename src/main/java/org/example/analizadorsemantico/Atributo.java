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

    void estaBienDeclarado(ClaseOInterfaz contexto) {
        tipo.estaBienDeclarado(contexto);
    }

    Atributo instanciar(String parametro, Tipo argumento) {
        if (parametro == null) {
            return this;
        }
        return new Atributo(token, tipo.instanciar(parametro, argumento));
    }
}
