package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public abstract class ClaseOInterfaz extends EntidadDeclarable {
    protected String nombre;
    protected String parametroGenericoOpcional;
    protected Map<String, Metodo> metodos;

    public ClaseOInterfaz(Token token) {
        super(token);
        nombre = token.lexema();
        metodos = new LinkedHashMap<>();
    }

    void agregarMetodo(Metodo metodo) {
        if (metodos.containsKey(metodo.getClave())) {
            throw new ErrorSemantico(metodo.token, "El metodo " + metodo.nombre + " con " + metodo.aridad()
                    + " parametros ya esta declarado en " + nombre);
        }
        metodos.put(metodo.getClave(), metodo);
    }

    abstract void estaBienDeclarado();

    abstract TipoReferencia getPadre();

    protected void chequearMetodos() {
        for (Metodo metodo : metodos.values()) {
            metodo.estaBienDeclarado(this);
        }
    }

    protected void chequearHerenciaCircular() {
        Set<ClaseOInterfaz> visitados = new HashSet<>();
        TipoReferencia padre = getPadre();
        while (padre != null) {
            ClaseOInterfaz ancestro = padre.getReferenciada();
            if (ancestro == this) {
                throw new ErrorSemantico(token, "Herencia circular en " + nombre);
            }
            if (ancestro == null || !visitados.add(ancestro)) {
                return;
            }
            padre = ancestro.getPadre();
        }
    }
}
