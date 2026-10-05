package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.ArrayList;
import java.util.List;

public class Metodo extends EntidadDeclarable {
    protected String nombre;
    protected boolean esEstatico;
    protected Tipo tipoRetorno;
    protected List<Parametro> parametrosOrdenados;

    public Metodo(Token token, boolean esEstatico, Tipo tipoRetorno) {
        super(token);
        nombre = token.lexema();
        this.esEstatico = esEstatico;
        this.tipoRetorno = tipoRetorno;
        parametrosOrdenados = new ArrayList<>();
    }

    public String getClave() {
        return nombre + "/" + parametrosOrdenados.size();
    }
}
