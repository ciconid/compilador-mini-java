///[Error:m2|6]
// La clave de un metodo es (nombre, aridad): no existe m2 sin parametros

class A1 {
    void m1() {
        m2();
    }

    void m2(int x) {
    }
}

class Init{
    static void main()
    { }
}
