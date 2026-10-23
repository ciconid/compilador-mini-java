package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.ast.NodoExpresion;

public class Atributo extends EntidadDeclarable {
    protected String nombre;
    protected Tipo tipo;
    protected Token tokenIgual;
    protected NodoExpresion inicializador;

    public Atributo(Token token, Tipo tipo) {
        super(token);
        nombre = token.lexema();
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setInicializador(Token tokenIgual, NodoExpresion inicializador) {
        this.tokenIgual = tokenIgual;
        this.inicializador = inicializador;
    }

    void estaBienDeclarado(ClaseOInterfaz contexto) {
        tipo.estaBienDeclarado(contexto);
    }

    void chequearInicializador() {
        if (inicializador == null) {
            return;
        }
        Tipo tipoInicializador = inicializador.chequear(tipo);
        if (!tipoInicializador.conformaCon(tipo)) {
            throw new ErrorSemantico(tokenIgual, "El inicializador de " + nombre + " es de tipo " + tipoInicializador
                    + " y no conforma con " + tipo);
        }
    }

    Atributo instanciar(String parametro, Tipo argumento) {
        if (parametro == null) {
            return this;
        }
        return new Atributo(token, tipo.instanciar(parametro, argumento));
    }
}
