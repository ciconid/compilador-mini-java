class ConTernarioBasico {
    boolean esMayor;
    int x;
    int m;
    int a;
    int b;
    int edad;

    void metodo() {
        esMayor = (edad >= 18) ? true : false;
        x = (a > b) ? 1 : 2;
        m = (a > b) ? a : b;
    }
}