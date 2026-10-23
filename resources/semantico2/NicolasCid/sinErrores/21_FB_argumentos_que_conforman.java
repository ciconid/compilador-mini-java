///[SinErrores]
// Los argumentos conforman con los formales por herencia, con null y con Object

class A1 {
}

class B2 extends A1 {
}

class Uso {
    void recibir(A1 a, Object o, String s) {
    }

    void m1(B2 b) {
        recibir(b, b, null);
        recibir(new B2(), "x", "y");
        recibir(null, new A1(), null);
    }
}

class Init{
    static void main()
    { }
}
