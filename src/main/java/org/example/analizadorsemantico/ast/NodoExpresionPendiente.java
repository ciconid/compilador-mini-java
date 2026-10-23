package org.example.analizadorsemantico.ast;

import org.example.analizadorsemantico.Tipo;
import org.example.analizadorsemantico.TipoPendiente;

public class NodoExpresionPendiente extends NodoExpresion {
    public Tipo chequear() {
        return new TipoPendiente();
    }
}
