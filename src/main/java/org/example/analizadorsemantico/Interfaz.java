package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.ArrayList;
import java.util.List;

public class Interfaz extends ClaseOInterfaz {
    protected List<TipoReferencia> superInterfaces;

    public Interfaz(Token token) {
        super(token);
        superInterfaces = new ArrayList<>();
    }

    List<TipoReferencia> getPadres() {
        return superInterfaces;
    }

    void estaBienDeclarado() {
        chequearListaDeInterfaces(superInterfaces);
        chequearHerenciaCircular();
        chequearMetodos();
    }

    void consolidar() {
        if (consolidado) {
            return;
        }
        for (TipoReferencia superInterfaz : superInterfaces) {
            superInterfaz.getReferenciada().consolidar();
        }
        heredarMetodos(superInterfaces);
        consolidado = true;
    }
}
