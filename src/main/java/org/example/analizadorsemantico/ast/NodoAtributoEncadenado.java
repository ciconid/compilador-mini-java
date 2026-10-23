package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

public class NodoAtributoEncadenado extends NodoEncadenado {
    private final Token token;
    private boolean esLength;

    public NodoAtributoEncadenado(NodoExpresion receptor, Token token) {
        super(receptor);
        this.token = token;
    }

    public Tipo chequear() {
        Tipo tipoReceptor = receptor.chequear();
        String nombre = token.lexema();
        if (tipoReceptor instanceof TipoArreglo) {
            if (!nombre.equals("length")) {
                throw new ErrorSemantico(token, "Los arreglos no tienen un atributo " + nombre);
            }
            esLength = true;
            return new TipoInt();
        }
        if (!(tipoReceptor instanceof TipoReferencia referencia)) {
            throw new ErrorSemantico(token, "No se puede acceder al atributo " + nombre + " sobre un valor de tipo "
                    + tipoReceptor);
        }
        Atributo atributo = referencia.getReferenciada().getAtributo(nombre);
        if (atributo == null) {
            throw new ErrorSemantico(token, "El atributo " + nombre + " no esta declarado en " + referencia);
        }
        return referencia.instanciarMiembro(atributo.getTipo());
    }

    public boolean esAsignable() {
        return !esLength && !tieneBaseParentizada();
    }
}
