package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.LinkedHashMap;
import java.util.Map;

public class Clase extends ClaseOInterfaz {
    protected TipoReferencia superclase;
    protected TipoReferencia interfazImplementada;
    protected Map<String, Atributo> atributos;
    protected Map<Integer, Constructor> constructores;

    public Clase(Token token) {
        super(token);
        superclase = new TipoReferencia(new Token("idClase", "Object", 0), null);
        atributos = new LinkedHashMap<>();
        constructores = new LinkedHashMap<>();
    }
}
