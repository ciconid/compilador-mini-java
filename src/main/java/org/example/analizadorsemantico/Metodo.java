package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class Metodo extends Unidad {
    protected String nombre;
    protected boolean esEstatico;
    protected Tipo tipoRetorno;
    protected boolean esFinal;

    public Metodo(Token token, boolean esEstatico, Tipo tipoRetorno) {
        super(token);
        nombre = token.lexema();
        this.esEstatico = esEstatico;
        this.tipoRetorno = tipoRetorno;
    }

    public void setEsFinal(boolean esFinal) {
        this.esFinal = esFinal;
    }

    public String getClave() {
        return nombre + "/" + aridad();
    }

    @Override
    void estaBienDeclarado(ClaseOInterfaz contexto) {
        tipoRetorno.estaBienDeclarado(contexto);
        super.estaBienDeclarado(contexto);
    }

    Metodo instanciar(String parametro, Tipo argumento) {
        if (parametro == null) {
            return this;
        }
        Metodo copia = new Metodo(token, esEstatico, tipoRetorno.instanciar(parametro, argumento));
        copia.esFinal = esFinal;
        for (Parametro p : parametrosOrdenados) {
            copia.agregarParametro(p.token, p.tipo.instanciar(parametro, argumento));
        }
        return copia;
    }

    boolean mismaSignatura(Metodo otro) {
        if (!tipoRetorno.esIgual(otro.tipoRetorno) || aridad() != otro.aridad()) {
            return false;
        }
        for (int i = 0; i < aridad(); i++) {
            if (!parametrosOrdenados.get(i).tipo.esIgual(otro.parametrosOrdenados.get(i).tipo)) {
                return false;
            }
        }
        return true;
    }
}
