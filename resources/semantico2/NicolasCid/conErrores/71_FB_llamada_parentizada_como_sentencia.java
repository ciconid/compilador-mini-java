///[Error:;|6]
// Una llamada entre parentesis no cuenta como llamada para validar una sentencia

class A1 {
    void m1() {
        (m2());
    }

    void m2() {
    }
}

class Init{
    static void main()
    { }
}
