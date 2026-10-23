package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

public class NodoPosfijo extends NodoExpresion {
    private final Token operador;
    private final NodoExpresion operando;

    public NodoPosfijo(Token operador, NodoExpresion operando) {
        this.operador = operador;
        this.operando = operando;
    }

    public Tipo chequear() {
        Tipo tipoOperando = operando.chequear();
        if (!tipoOperando.conformaCon(new TipoInt())) {
            throw new ErrorSemantico(operador, "El operador " + operador.lexema() + " requiere un operando de tipo int"
                    + ", pero es de tipo " + tipoOperando);
        }
        if (!operando.esAsignable()) {
            throw new ErrorSemantico(operador, "El operando de " + operador.lexema() + " no es asignable");
        }
        return new TipoInt();
    }

    public boolean esAsignacion() {
        return true;
    }
}
