package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

public class NodoExpBinaria extends NodoExpresion {
    private final Token operador;
    private final NodoExpresion ladoIzq;
    private final NodoExpresion ladoDer;

    public NodoExpBinaria(Token operador, NodoExpresion ladoIzq, NodoExpresion ladoDer) {
        this.operador = operador;
        this.ladoIzq = ladoIzq;
        this.ladoDer = ladoDer;
    }

    public Tipo chequear() {
        Tipo tipoIzq = ladoIzq.chequear();
        Tipo tipoDer = ladoDer.chequear();
        switch (operador.token()) {
            case "opSuma", "opResta", "opMultiplicacion", "opDivision", "opModulo" -> {
                chequearOperandos(tipoIzq, tipoDer, new TipoInt());
                return new TipoInt();
            }
            case "opMenor", "opMayor", "opMenorIgual", "opMayorIgual" -> {
                chequearOperandos(tipoIzq, tipoDer, new TipoInt());
                return new TipoBoolean();
            }
            case "opAnd", "opOr" -> {
                chequearOperandos(tipoIzq, tipoDer, new TipoBoolean());
                return new TipoBoolean();
            }
            default -> {
                if (!tipoIzq.conformaCon(tipoDer) && !tipoDer.conformaCon(tipoIzq)) {
                    throw new ErrorSemantico(operador, "No se pueden comparar con " + operador.lexema()
                            + " los tipos " + tipoIzq + " y " + tipoDer);
                }
                return new TipoBoolean();
            }
        }
    }

    private void chequearOperandos(Tipo tipoIzq, Tipo tipoDer, Tipo tipoEsperado) {
        if (!tipoIzq.conformaCon(tipoEsperado) || !tipoDer.conformaCon(tipoEsperado)) {
            throw new ErrorSemantico(operador, "El operador " + operador.lexema() + " requiere operandos de tipo "
                    + tipoEsperado + ", pero son de tipo " + tipoIzq + " y " + tipoDer);
        }
    }
}
