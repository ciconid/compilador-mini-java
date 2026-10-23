///[Error:m2|6]
// En un metodo estatico una llamada sin receptor solo puede seleccionar un metodo estatico

class A1 {
    static void m1() {
        m2();
    }

    void m2() {
    }
}

class Init{
    static void main()
    { }
}
