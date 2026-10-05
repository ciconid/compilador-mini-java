package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

public class Interfaz extends ClaseOInterfaz {
    protected TipoReferencia superInterfaz;

    public Interfaz(Token token) {
        super(token);
    }

    TipoReferencia getPadre() {
        return superInterfaz;
    }

    void estaBienDeclarado() {
        if (superInterfaz != null) {
            superInterfaz.estaBienDeclarado(this);
            if (!(superInterfaz.getReferenciada() instanceof Interfaz)) {
                throw new ErrorSemantico(superInterfaz.token, superInterfaz.nombre + " no es una interfaz");
            }
        }
        chequearHerenciaCircular();
        chequearMetodos();
    }

    void consolidar() {
        if (consolidado) {
            return;
        }
        if (superInterfaz != null) {
            Interfaz padre = (Interfaz) superInterfaz.getReferenciada();
            padre.consolidar();
            heredarMetodos(padre, superInterfaz);
        }
        consolidado = true;
    }
}
