package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class Constructor extends Unidad {

    public Constructor(Token token) {
        super(token);
    }

    public Tipo getTipoRetorno() {
        return new TipoVoid();
    }
}
