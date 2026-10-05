package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class Metodo extends Unidad {
    protected String nombre;
    protected boolean esEstatico;
    protected Tipo tipoRetorno;

    public Metodo(Token token, boolean esEstatico, Tipo tipoRetorno) {
        super(token);
        nombre = token.lexema();
        this.esEstatico = esEstatico;
        this.tipoRetorno = tipoRetorno;
    }

    public String getClave() {
        return nombre + "/" + aridad();
    }
}
