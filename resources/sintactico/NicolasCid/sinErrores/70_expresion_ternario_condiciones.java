class ConTernarioCondiciones {
    boolean flag;
    int x;
    int a;
    int b;

    void metodo() {
        x = (flag) ? 1 : 0;
        x = (a > 0 && b < 10) ? 1 : 0;
        x = ((a > b)) ? a : b;
    }
}