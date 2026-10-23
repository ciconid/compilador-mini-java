package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.ErrorSemantico;
import org.example.analizadorsemantico.TablaDeSimbolos;
import org.example.analizadorsemantico.Tipo;

public class NodoThis extends NodoExpresion {
    private final Token token;

    public NodoThis(Token token) {
        this.token = token;
    }

    public Tipo chequear() {
        if (TablaDeSimbolos.ts.enContextoEstatico()) {
            throw new ErrorSemantico(token, "No se puede usar this en un metodo estatico");
        }
        return TablaDeSimbolos.ts.getClaseActual().getTipoPropio();
    }
}
