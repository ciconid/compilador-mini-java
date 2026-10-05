package org.example.analizadorsemantico;

import org.example.analizadorlexico.Token;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ClaseOInterfaz extends EntidadDeclarable {
    protected String nombre;
    protected String parametroGenericoOpcional;
    protected Map<String, Metodo> metodos;
    protected boolean consolidado;

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

    abstract List<TipoReferencia> getPadres();

    protected void chequearMetodos() {
        for (Metodo metodo : metodos.values()) {
            metodo.estaBienDeclarado(this);
        }
    }

    protected void chequearListaDeInterfaces(List<TipoReferencia> interfaces) {
        Set<String> nombres = new HashSet<>();
        for (TipoReferencia interfaz : interfaces) {
            interfaz.estaBienDeclarado(this);
            if (!(interfaz.getReferenciada() instanceof Interfaz)) {
                throw new ErrorSemantico(interfaz.token, interfaz.nombre + " no es una interfaz");
            }
            if (!nombres.add(interfaz.nombre)) {
                throw new ErrorSemantico(interfaz.token, "La interfaz " + interfaz.nombre + " esta repetida en "
                        + nombre);
            }
        }
    }

    protected void chequearHerenciaCircular() {
        buscarCiclo(this, new HashSet<>());
    }

    private void buscarCiclo(ClaseOInterfaz actual, Set<ClaseOInterfaz> visitados) {
        for (TipoReferencia padre : actual.getPadres()) {
            ClaseOInterfaz ancestro = padre.getReferenciada();
            if (ancestro == this) {
                throw new ErrorSemantico(token, "Herencia circular en " + nombre);
            }
            if (ancestro != null && visitados.add(ancestro)) {
                buscarCiclo(ancestro, visitados);
            }
        }
    }

    abstract void consolidar();

    protected String parametroAInstanciar(ClaseOInterfaz padre, TipoReferencia referenciaAlPadre) {
        if (padre.parametroGenericoOpcional != null && referenciaAlPadre.argumentoGenerico != null) {
            return padre.parametroGenericoOpcional;
        }
        return null;
    }

    protected void heredarMetodos(List<TipoReferencia> referenciasAPadres) {
        Map<String, Metodo> heredados = new LinkedHashMap<>();
        for (TipoReferencia referenciaAlPadre : referenciasAPadres) {
            ClaseOInterfaz padre = referenciaAlPadre.getReferenciada();
            String parametro = parametroAInstanciar(padre, referenciaAlPadre);
            for (Metodo metodoPadre : padre.metodos.values()) {
                Metodo heredado = metodoPadre.instanciar(parametro, referenciaAlPadre.argumentoGenerico);
                Metodo previo = heredados.get(heredado.getClave());
                if (previo == null) {
                    heredados.put(heredado.getClave(), heredado);
                } else if (previo.esEstatico != heredado.esEstatico || !previo.mismaSignatura(heredado)) {
                    throw new ErrorSemantico(token, nombre + " hereda versiones incompatibles del metodo "
                            + heredado.nombre);
                }
            }
        }
        Map<String, Metodo> consolidados = new LinkedHashMap<>();
        for (Metodo heredado : heredados.values()) {
            Metodo propio = metodos.get(heredado.getClave());
            if (propio == null) {
                consolidados.put(heredado.getClave(), heredado);
            } else {
                chequearRedefinicion(heredado, propio);
                consolidados.put(propio.getClave(), propio);
            }
        }
        for (Metodo propio : metodos.values()) {
            consolidados.putIfAbsent(propio.getClave(), propio);
        }
        metodos = consolidados;
    }

    private void chequearRedefinicion(Metodo heredado, Metodo propio) {
        if (heredado.esEstatico) {
            throw new ErrorSemantico(propio.token, "El metodo " + propio.nombre
                    + " no puede redefinir un metodo estatico heredado");
        }
        if (propio.esEstatico) {
            throw new ErrorSemantico(propio.token, "El metodo estatico " + propio.nombre
                    + " no puede tener la misma clave que un metodo de instancia heredado");
        }
        if (!propio.mismaSignatura(heredado)) {
            throw new ErrorSemantico(propio.token, "El metodo " + propio.nombre + " esta mal redefinido");
        }
    }
}
