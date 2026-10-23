package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.ast.NodoBloque;

import java.util.ArrayList;
import java.util.List;

public abstract class Unidad extends EntidadDeclarable {
    protected List<Parametro> parametrosOrdenados;
    protected NodoBloque bloque;

    public Unidad(Token token) {
        super(token);
        parametrosOrdenados = new ArrayList<>();
        bloque = new NodoBloque();
    }

    public void setBloque(NodoBloque bloque) {
        this.bloque = bloque;
    }

    public void agregarParametro(Token token, Tipo tipo) {
        for (Parametro p : parametrosOrdenados) {
            if (p.nombre.equals(token.lexema())) {
                throw new ErrorSemantico(token, "El parametro " + token.lexema() + " ya esta declarado");
            }
        }
        parametrosOrdenados.add(new Parametro(token, tipo, parametrosOrdenados.size()));
    }

    public abstract Tipo getTipoRetorno();

    public int aridad() {
        return parametrosOrdenados.size();
    }

    void estaBienDeclarado(ClaseOInterfaz contexto) {
        for (Parametro parametro : parametrosOrdenados) {
            parametro.tipo.estaBienDeclarado(contexto);
        }
    }
}
