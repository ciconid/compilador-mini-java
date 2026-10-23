package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

import java.util.List;

public class NodoLlamadaMetodo extends NodoExpresion {
    private final Token token;
    private final List<NodoExpresion> argumentos;

    public NodoLlamadaMetodo(Token token, List<NodoExpresion> argumentos) {
        this.token = token;
        this.argumentos = argumentos;
    }

    public Tipo chequear() {
        String nombre = token.lexema();
        ClaseOInterfaz clase = TablaDeSimbolos.ts.getClaseActual();
        Metodo metodo = clase.getMetodo(nombre, argumentos.size());
        if (metodo == null) {
            throw new ErrorSemantico(token, "El metodo " + nombre + " con " + argumentos.size()
                    + " parametros no esta declarado en " + clase.getNombre());
        }
        if (TablaDeSimbolos.ts.getUnidadActual().esEstatico() && !metodo.esEstatico()) {
            throw new ErrorSemantico(token, "No se puede llamar al metodo de instancia " + nombre
                    + " desde un metodo estatico");
        }
        TipoReferencia receptor = clase.getTipoPropio();
        metodo.chequearArgumentos(argumentos, receptor, token);
        return receptor.instanciarMiembro(metodo.getTipoRetorno());
    }

    public boolean esLlamada() {
        return true;
    }
}
