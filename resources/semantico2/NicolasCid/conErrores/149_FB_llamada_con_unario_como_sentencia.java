///[Error:;|10]
// Una llamada precedida por un operador unario deja de clasificarse como llamada para validar la sentencia

class A1 {
    int m2() {
        return 1;
    }

    void m1() {
        -m2();
    }
}

class Init{
    static void main()
    { }
}
