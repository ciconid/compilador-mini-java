package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.LinkedHashMap;
import java.util.Map;

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
}
