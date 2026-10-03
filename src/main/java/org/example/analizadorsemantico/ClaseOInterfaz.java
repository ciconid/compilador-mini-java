package org.example.analizadorsemantico;

import java.util.Map;

public abstract class ClaseOInterfaz extends EntidadDeclarable {
    protected String nombre;
    protected String parametroGenericoOpcional;
    protected Map<String, Metodo> metodos;
}
