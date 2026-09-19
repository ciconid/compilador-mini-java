class ConTernarioEnContextos {
    int a;
    int b;
    int n;
    int nro;

    int imprimir(int valor) {
        return valor;
    }

    void metodo() {
        var m = (a > b) ? a : b;
        nro = imprimir((a > b) ? a : b);
    }

    int otro() {
        return (n < 0) ? -n : n;
    }
}