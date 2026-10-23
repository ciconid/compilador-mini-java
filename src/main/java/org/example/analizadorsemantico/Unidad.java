package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.ast.NodoBloque;
import org.example.analizadorsemantico.ast.NodoExpresion;

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

    public boolean esEstatico() {
        return false;
    }

    public Parametro getParametro(String nombre) {
        for (Parametro parametro : parametrosOrdenados) {
            if (parametro.nombre.equals(nombre)) {
                return parametro;
            }
        }
        return null;
    }

    public int aridad() {
        return parametrosOrdenados.size();
    }

    public void chequearArgumentos(List<NodoExpresion> argumentos, TipoReferencia receptor, Token token) {
        for (int i = 0; i < argumentos.size(); i++) {
            Tipo tipoFormal = receptor.instanciarMiembro(parametrosOrdenados.get(i).tipo);
            Tipo tipoActual = argumentos.get(i).chequear(tipoFormal);
            if (!tipoActual.conformaCon(tipoFormal)) {
                throw new ErrorSemantico(token, "El argumento " + (i + 1) + " es de tipo " + tipoActual
                        + ", que no conforma con el parametro formal de tipo " + tipoFormal);
            }
        }
    }

    void estaBienDeclarado(ClaseOInterfaz contexto) {
        for (Parametro parametro : parametrosOrdenados) {
            parametro.tipo.estaBienDeclarado(contexto);
        }
    }
}
