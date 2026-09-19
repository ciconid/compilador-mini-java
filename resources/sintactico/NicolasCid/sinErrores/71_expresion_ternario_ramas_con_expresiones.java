class ConTernarioRamasConExpresiones {
    boolean c;
    int x;
    int a;
    int b;
    boolean p;
    boolean q;
    boolean r;

    int f(int valor) {
        return valor;
    }

    int g(int valor) {
        return valor;
    }

    void metodo() {
        x = (c) ? a + 1 : b * 2;
        x = (c) ? f(a) : g(b);
        x = (c) ? -a : +b;
        r = (c) ? !p : q;
        x = (c) ? (a + b) : (a - b);
    }
}