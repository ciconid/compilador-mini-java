///[SinErrores]
// Un metodo estatico puede llamarse a traves de una instancia, y una llamada estatica puede encadenarse

class A1 {
    int x;

    static A1 crear() {
        return new A1();
    }

    static void est() {}
}

class B1 {
    static void m1(A1 a) {
        a.est();
        a.x = 2;
        var n = A1.crear().x;
        A1.crear().x = n;
        A1.crear().crear().est();
    }
}

class Init{
    static void main()
    { }
}
