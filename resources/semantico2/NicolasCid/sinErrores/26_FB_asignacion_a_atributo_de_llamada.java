///[SinErrores]
// El atributo de un objeto devuelto por una llamada es asignable, y una llamada encadenada es sentencia

class A1 {
    int x;

    A1 crearA() {
        return new A1();
    }

    void m2() {}

    void m1() {
        crearA().x = 3;
        crearA().m2();
        new A1().x = 4;
        new A1().crearA().m2();
    }
}

class Init{
    static void main()
    { }
}
