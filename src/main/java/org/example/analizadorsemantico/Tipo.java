package org.example.analizadorsemantico;

public abstract class Tipo {
    abstract void estaBienDeclarado(ClaseOInterfaz contexto);

    abstract Tipo instanciar(String parametro, Tipo argumento);

    abstract boolean esIgual(Tipo otro);
}
