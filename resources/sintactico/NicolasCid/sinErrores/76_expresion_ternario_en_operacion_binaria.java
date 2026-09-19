class ConTernarioEnOperacionBinaria {
    boolean c;
    int x;
    int a;
    int b;

    void metodo() {
        x = 1 + (c) ? a : b;
        x = ((c) ? a : b) + 1;
    }
}