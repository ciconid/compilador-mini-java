package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.ArrayList;
import java.util.List;

public class TipoReferencia extends Tipo {
    protected Token token;
    protected String nombre;
    protected Tipo argumentoGenerico;

    public TipoReferencia(Token token, Tipo argumentoGenerico) {
        this.token = token;
        nombre = token.lexema();
        this.argumentoGenerico = argumentoGenerico;
    }

    public ClaseOInterfaz getReferenciada() {
        return TablaDeSimbolos.ts.getClaseOInterfaz(nombre);
    }

    public void estaBienDeclarado(ClaseOInterfaz contexto) {
        ClaseOInterfaz referenciada = getReferenciada();
        if (referenciada == null) {
            throw new ErrorSemantico(token, "La clase o interfaz " + nombre + " no esta declarada");
        }
        if (argumentoGenerico != null) {
            if (referenciada.parametroGenericoOpcional == null) {
                throw new ErrorSemantico(token, nombre + " no es generica");
            }
            argumentoGenerico.estaBienUsado(contexto);
        }
    }

    public void estaBienUsado(ClaseOInterfaz contexto) {
        estaBienDeclarado(contexto);
        if (argumentoGenerico == null && getReferenciada().esGenerica()) {
            throw new ErrorSemantico(token, "La clase o interfaz generica " + nombre + " requiere un argumento de tipo");
        }
    }

    Tipo instanciar(TipoParametro parametro, Tipo argumento) {
        if (argumentoGenerico == null) {
            return this;
        }
        return new TipoReferencia(token, argumentoGenerico.instanciar(parametro, argumento));
    }

    TipoParametro getParametroUsado() {
        return argumentoGenerico == null ? null : argumentoGenerico.getParametroUsado();
    }

    boolean esIgual(Tipo otro) {
        if (!(otro instanceof TipoReferencia referencia) || !referencia.nombre.equals(nombre)) {
            return false;
        }
        if (argumentoGenerico == null) {
            return referencia.argumentoGenerico == null;
        }
        return argumentoGenerico.esIgual(referencia.argumentoGenerico);
    }

    public boolean conformaCon(Tipo destino) {
        if (super.conformaCon(destino)) {
            return true;
        }
        if (!(destino instanceof TipoReferencia referenciaDestino)) {
            return false;
        }
        if (referenciaDestino.esObject()) {
            return true;
        }
        for (TipoReferencia supertipo : getSupertiposDirectos()) {
            if (supertipo.conformaCon(destino)) {
                return true;
            }
        }
        return false;
    }

    boolean esObject() {
        return nombre.equals("Object") && argumentoGenerico == null;
    }

    private List<TipoReferencia> getSupertiposDirectos() {
        List<TipoReferencia> supertipos = new ArrayList<>();
        for (TipoReferencia supertipo : getReferenciada().getSupertiposDirectos()) {
            supertipos.add((TipoReferencia) instanciarMiembro(supertipo));
        }
        return supertipos;
    }

    public Tipo instanciarMiembro(Tipo tipoMiembro) {
        ClaseOInterfaz referenciada = getReferenciada();
        if (!referenciada.esGenerica() || argumentoGenerico == null) {
            return tipoMiembro;
        }
        return tipoMiembro.instanciar(referenciada.getParametroFormal(), argumentoGenerico);
    }

    public TipoReferencia supertipoComun(TipoReferencia otro) {
        List<TipoReferencia> comunes = new ArrayList<>();
        for (TipoReferencia ancestro : getAncestros()) {
            if (otro.conformaCon(ancestro) && comunes.stream().noneMatch(ancestro::esIgual)) {
                comunes.add(ancestro);
            }
        }
        List<TipoReferencia> minimos = new ArrayList<>();
        for (TipoReferencia comun : comunes) {
            if (comunes.stream().noneMatch(c -> !c.esIgual(comun) && c.conformaCon(comun))) {
                minimos.add(comun);
            }
        }
        for (TipoReferencia minimo : minimos) {
            if (minimo.getReferenciada() instanceof Clase) {
                return minimo;
            }
        }
        return minimos.isEmpty() ? object(token.nroDeLinea()) : minimos.get(0);
    }

    public static TipoReferencia object(int nroDeLinea) {
        return new TipoReferencia(new Token("idClase", "Object", nroDeLinea), null);
    }

    private List<TipoReferencia> getAncestros() {
        List<TipoReferencia> ancestros = new ArrayList<>(List.of(this));
        for (TipoReferencia supertipo : getSupertiposDirectos()) {
            ancestros.addAll(supertipo.getAncestros());
        }
        return ancestros;
    }

    private TipoReferencia getAncestro(String nombreAncestro) {
        if (nombre.equals(nombreAncestro)) {
            return this;
        }
        for (TipoReferencia supertipo : getSupertiposDirectos()) {
            TipoReferencia ancestro = supertipo.getAncestro(nombreAncestro);
            if (ancestro != null) {
                return ancestro;
            }
        }
        return null;
    }

    public Tipo inferirArgumento(Tipo esperado) {
        if (esperado instanceof TipoReferencia referenciaEsperada && referenciaEsperada.argumentoGenerico != null) {
            TipoReferencia ancestro = getAncestro(referenciaEsperada.nombre);
            if (ancestro != null && ancestro.argumentoGenerico != null
                    && ancestro.argumentoGenerico.esIgual(argumentoGenerico)) {
                return referenciaEsperada.argumentoGenerico;
            }
        }
        return object(token.nroDeLinea());
    }

    public String toString() {
        return argumentoGenerico == null ? nombre : nombre + "<" + argumentoGenerico + ">";
    }
}
