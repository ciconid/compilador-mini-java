class ConTernarioAnidado {
    boolean a;
    int b;
    int c;
    boolean d;
    boolean e;
    int x;
    boolean res;

    void metodo() {
        x = (a) ? 1 : (b) ? 2 : 3;
        x = (a) ? (b) ? 1 : 2 : 3;
        res = ((a) ? d : e) ? true : false;
    }
}