package org.example.analizadorsemantico;

import java.util.LinkedHashMap;
import java.util.Map;

public class TablaDeSimbolos {
    private final Map<String, ClaseOInterfaz> clasesOInterfaces;

    public TablaDeSimbolos() {
        clasesOInterfaces = new LinkedHashMap<>();
        cargarPredefinidas();
    }

    private void cargarPredefinidas() {
        
    }
}
