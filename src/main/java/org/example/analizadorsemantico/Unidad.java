package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.ArrayList;
import java.util.List;

public abstract class Unidad extends EntidadDeclarable {
    protected List<Parametro> parametrosOrdenados;

    public Unidad(Token token) {
        super(token);
        parametrosOrdenados = new ArrayList<>();
    }

    public void agregarParametro(Token token, Tipo tipo) {
        for (Parametro p : parametrosOrdenados) {
            if (p.nombre.equals(token.lexema())) {
                throw new ErrorSemantico(token, "El parametro " + token.lexema() + " ya esta declarado");
            }
        }
        parametrosOrdenados.add(new Parametro(token, tipo, parametrosOrdenados.size()));
    }

    public int aridad() {
        return parametrosOrdenados.size();
    }

    void estaBienDeclarado(ClaseOInterfaz contexto) {
        for (Parametro parametro : parametrosOrdenados) {
            parametro.tipo.estaBienDeclarado(contexto);
        }
    }
}
