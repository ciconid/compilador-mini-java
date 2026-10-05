package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.ArrayList;
import java.util.List;

public class Constructor extends EntidadDeclarable {
    protected List<Parametro> parametrosOrdenados;

    public Constructor(Token token) {
        super(token);
        parametrosOrdenados = new ArrayList<>();
    }
}
