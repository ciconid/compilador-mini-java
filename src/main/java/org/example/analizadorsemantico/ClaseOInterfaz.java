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
    protected Token modificador;
    protected Token tokenPermits;
    protected List<Token> permitidos;

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

    abstract List<TipoReferencia> getSupertiposDirectos();

    boolean esSealed() {
        return modificador != null && modificador.token().equals("prSealed");
    }

    boolean esNonSealed() {
        return modificador != null && modificador.token().equals("prNonSealed");
    }

    boolean esFinal() {
        return modificador != null && modificador.token().equals("prFinal");
    }

    boolean heredaDirectamenteDe(String nombrePadre) {
        for (TipoReferencia supertipo : getSupertiposDirectos()) {
            if (supertipo.nombre.equals(nombrePadre)) {
                return true;
            }
        }
        return false;
    }

    private boolean permite(String nombreSubtipo) {
        for (Token permitido : permitidos) {
            if (permitido.lexema().equals(nombreSubtipo)) {
                return true;
            }
        }
        return false;
    }

    protected void chequearModificadores() {
        boolean tienePadreSealed = false;
        for (TipoReferencia supertipo : getSupertiposDirectos()) {
            ClaseOInterfaz padre = supertipo.getReferenciada();
            if (padre.esFinal()) {
                throw new ErrorSemantico(supertipo.token, nombre + " no puede heredar de " + padre.nombre
                        + " porque es final");
            }
            if (padre.esSealed()) {
                tienePadreSealed = true;
                if (padre.permitidos != null && !padre.permite(nombre)) {
                    throw new ErrorSemantico(supertipo.token, nombre + " no esta permitido por el tipo sealed "
                            + padre.nombre);
                }
            }
        }
        if (tienePadreSealed && modificador == null) {
            throw new ErrorSemantico(token, nombre + " hereda de un tipo sealed y debe ser final, sealed o non-sealed");
        }
        if (esNonSealed() && !tienePadreSealed) {
            throw new ErrorSemantico(token, nombre + " es non-sealed pero no hereda de un tipo sealed");
        }
        chequearPermits();
    }

    private void chequearPermits() {
        if (tokenPermits != null && !esSealed()) {
            throw new ErrorSemantico(tokenPermits, "Solo un tipo sealed puede tener permits, y " + nombre
                    + " no lo es");
        }
        if (!esSealed()) {
            return;
        }
        if (permitidos == null) {
            if (!TablaDeSimbolos.ts.tieneSubtipoDirecto(nombre)) {
                throw new ErrorSemantico(token, "El tipo sealed " + nombre + " no tiene subtipos directos");
            }
            return;
        }
        Set<String> nombres = new HashSet<>();
        for (Token permitido : permitidos) {
            if (!nombres.add(permitido.lexema())) {
                throw new ErrorSemantico(permitido, permitido.lexema() + " esta repetido en el permits de " + nombre);
            }
            ClaseOInterfaz subtipo = TablaDeSimbolos.ts.getClaseOInterfaz(permitido.lexema());
            if (subtipo == null) {
                throw new ErrorSemantico(permitido, "La clase o interfaz " + permitido.lexema()
                        + " no esta declarada");
            }
            if (!subtipo.heredaDirectamenteDe(nombre)) {
                throw new ErrorSemantico(permitido, permitido.lexema() + " esta en el permits de " + nombre
                        + " pero no hereda directamente de el");
            }
        }
    }

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
        if (heredado.esFinal) {
            throw new ErrorSemantico(propio.token, "El metodo " + propio.nombre + " no puede redefinir un metodo final");
        }
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
