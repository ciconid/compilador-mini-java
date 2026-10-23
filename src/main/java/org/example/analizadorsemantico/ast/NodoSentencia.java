package org.example.analizadorsemantico.ast;

public abstract class NodoSentencia {
    public abstract void chequear();

    public void chequearComoCuerpo() {
        chequear();
    }
}
