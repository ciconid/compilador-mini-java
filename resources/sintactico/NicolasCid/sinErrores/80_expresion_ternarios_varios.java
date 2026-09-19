class ConTernariosVarios {
    boolean c;
    boolean d;
    int a;
    int b;
    int x;
    int y;

    void metodo() {
        x = (c) ? a : b;
        y = (d) ? b : a;
        x = (c) ? y : x;
        y = (d) ? (c) ? a : b : x;
    }
}