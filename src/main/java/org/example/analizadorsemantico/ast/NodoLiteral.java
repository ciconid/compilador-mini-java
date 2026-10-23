package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

public class NodoLiteral extends NodoExpresion {
    private final Token token;

    public NodoLiteral(Token token) {
        this.token = token;
    }

    public Tipo chequear() {
        return switch (token.token()) {
            case "intLiteral" -> new TipoInt();
            case "charLiteral" -> new TipoChar();
            case "prTrue", "prFalse" -> new TipoBoolean();
            case "stringLiteral" -> new TipoReferencia(new Token("idClase", "String", token.nroDeLinea()), null);
            default -> new TipoNull();
        };
    }
}
