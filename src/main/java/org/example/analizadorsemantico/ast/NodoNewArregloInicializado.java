package org.example.analizadorsemantico.ast;

import org.example.analizadorsemantico.*;

public class NodoNewArregloInicializado extends NodoExpresion {
    private final Tipo tipoBase;
    private final int dimensiones;
    private final NodoInicializadorArreglo inicializador;

    public NodoNewArregloInicializado(Tipo tipoBase, int dimensiones, NodoInicializadorArreglo inicializador) {
        this.tipoBase = tipoBase;
        this.dimensiones = dimensiones;
        this.inicializador = inicializador;
    }

    public Tipo chequear() {
        tipoBase.estaBienUsado(TablaDeSimbolos.ts.getClaseActual());
        if (TablaDeSimbolos.ts.enContextoEstatico()) {
            tipoBase.chequearSinParametroDeTipo();
        }
        TipoArreglo tipo = new TipoArreglo(tipoBase, dimensiones);
        inicializador.chequear(tipo);
        return tipo;
    }
}
