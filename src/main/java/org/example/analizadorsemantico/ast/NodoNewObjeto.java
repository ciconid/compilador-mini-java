package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

import java.util.List;

public class NodoNewObjeto extends NodoExpresion {
    private final Token tokenClase;
    private final Tipo argumentoGenerico;
    private final boolean diamante;
    private final List<NodoExpresion> argumentos;

    public NodoNewObjeto(Token tokenClase, Tipo argumentoGenerico, boolean diamante, List<NodoExpresion> argumentos) {
        this.tokenClase = tokenClase;
        this.argumentoGenerico = argumentoGenerico;
        this.diamante = diamante;
        this.argumentos = argumentos;
    }

    public Tipo chequear() {
        return chequear(null);
    }

    public Tipo chequear(Tipo esperado) {
        String nombre = tokenClase.lexema();
        TipoReferencia tipo = new TipoReferencia(tokenClase, argumentoGenerico);
        tipo.estaBienDeclarado(TablaDeSimbolos.ts.getClaseActual());
        if (TablaDeSimbolos.ts.enContextoEstatico()) {
            tipo.chequearSinParametroDeTipo();
        }
        if (!(tipo.getReferenciada() instanceof Clase clase)) {
            throw new ErrorSemantico(tokenClase, "No se puede crear una instancia de " + nombre
                    + " porque no es una clase");
        }
        if (diamante) {
            if (!clase.esGenerica()) {
                throw new ErrorSemantico(tokenClase, nombre + " no es generica");
            }
            tipo = new TipoReferencia(tokenClase, clase.getTipoPropio().inferirArgumento(esperado));
        } else if (clase.esGenerica() && argumentoGenerico == null) {
            throw new ErrorSemantico(tokenClase, "La clase generica " + nombre + " requiere un argumento de tipo");
        }
        Constructor constructor = clase.getConstructor(argumentos.size());
        if (constructor == null) {
            throw new ErrorSemantico(tokenClase, "La clase " + nombre + " no tiene un constructor con "
                    + argumentos.size() + " parametros");
        }
        constructor.chequearArgumentos(argumentos, tipo, tokenClase);
        return tipo;
    }

    public boolean esLlamada() {
        return true;
    }
}
