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

    ClaseOInterfaz getReferenciada() {
        return TablaDeSimbolos.ts.getClaseOInterfaz(nombre);
    }

    void estaBienDeclarado(ClaseOInterfaz contexto) {
        ClaseOInterfaz referenciada = getReferenciada();
        if (referenciada == null) {
            throw new ErrorSemantico(token, "La clase o interfaz " + nombre + " no esta declarada");
        }
        if (argumentoGenerico != null) {
            if (referenciada.parametroGenericoOpcional == null) {
                throw new ErrorSemantico(token, nombre + " no es generica");
            }
            argumentoGenerico.estaBienDeclarado(contexto);
        }
    }
}
