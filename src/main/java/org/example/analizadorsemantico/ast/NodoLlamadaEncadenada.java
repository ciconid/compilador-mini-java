package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

import java.util.List;

public class NodoLlamadaEncadenada extends NodoEncadenado {
    private final Token token;
    private final List<NodoExpresion> argumentos;

    public NodoLlamadaEncadenada(NodoExpresion receptor, Token token, List<NodoExpresion> argumentos) {
        super(receptor);
        this.token = token;
        this.argumentos = argumentos;
    }

    public Tipo chequear() {
        Tipo tipoReceptor = receptor.chequear();
        String nombre = token.lexema();
        TipoReferencia vista = getVistaDelReceptor(tipoReceptor);
        ClaseOInterfaz clase = vista.getReferenciada();
        Metodo metodo = clase.getMetodo(nombre, argumentos.size());
        if (metodo == null && clase instanceof Interfaz) {
            metodo = TablaDeSimbolos.ts.getClaseOInterfaz("Object").getMetodo(nombre, argumentos.size());
        }
        if (metodo == null) {
            throw new ErrorSemantico(token, "El metodo " + nombre + " con " + argumentos.size()
                    + " parametros no esta declarado en " + tipoReceptor);
        }
        metodo.chequearArgumentos(argumentos, vista, token);
        return vista.instanciarMiembro(metodo.getTipoRetorno());
    }

    private TipoReferencia getVistaDelReceptor(Tipo tipoReceptor) {
        if (tipoReceptor instanceof TipoArreglo && token.lexema().equals("toString") && argumentos.isEmpty()) {
            return TipoReferencia.object(token.nroDeLinea());
        }
        if (tipoReceptor instanceof TipoReferencia referencia) {
            return referencia;
        }
        throw new ErrorSemantico(token, "No se puede llamar al metodo " + token.lexema()
                + " sobre un valor de tipo " + tipoReceptor);
    }

    public boolean esLlamada() {
        return !tieneBaseParentizada();
    }
}
