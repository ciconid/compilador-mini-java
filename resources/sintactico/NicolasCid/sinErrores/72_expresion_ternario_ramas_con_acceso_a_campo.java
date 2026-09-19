class Otra {
    int campo;
}

class ConTernarioRamasConAccesoACampo {
    Otra o;
    int x;

    void metodo() {
        x = (o != null) ? o.campo : 0;
    }
}