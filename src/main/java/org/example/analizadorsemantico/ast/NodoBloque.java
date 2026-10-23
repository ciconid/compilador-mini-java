package org.example.analizadorsemantico.ast;

import org.example.analizadorsemantico.TablaDeSimbolos;

import java.util.ArrayList;
import java.util.List;

public class NodoBloque extends NodoSentencia {
    private final List<NodoSentencia> sentencias;

    public NodoBloque() {
        sentencias = new ArrayList<>();
    }

    public void agregarSentencia(NodoSentencia sentencia) {
        sentencias.add(sentencia);
    }

    public void chequear() {
        TablaDeSimbolos.ts.abrirAmbito();
        for (NodoSentencia sentencia : sentencias) {
            sentencia.chequear();
        }
        TablaDeSimbolos.ts.cerrarAmbito();
    }
}
