package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

public class NodoAccesoArreglo extends NodoEncadenado {
    private final Token tokenCorchete;
    private final NodoExpresion indice;

    public NodoAccesoArreglo(NodoExpresion receptor, Token tokenCorchete, NodoExpresion indice) {
        super(receptor);
        this.tokenCorchete = tokenCorchete;
        this.indice = indice;
    }

    public Tipo chequear() {
        Tipo tipoReceptor = receptor.chequear();
        Tipo tipoIndice = indice.chequear();
        if (!tipoIndice.conformaCon(new TipoInt())) {
            throw new ErrorSemantico(tokenCorchete, "El indice de un acceso a arreglo tiene que ser int, no "
                    + tipoIndice);
        }
        if (tipoReceptor instanceof TipoPendiente) {
            return tipoReceptor;
        }
        if (!(tipoReceptor instanceof TipoArreglo arreglo)) {
            throw new ErrorSemantico(tokenCorchete, "Solo se pueden indexar arreglos, no un valor de tipo "
                    + tipoReceptor);
        }
        return arreglo.getTipoComponente();
    }

    public boolean esAsignable() {
        return !tieneBaseParentizada();
    }
}
