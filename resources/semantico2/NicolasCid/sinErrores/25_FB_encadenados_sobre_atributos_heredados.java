///[SinErrores]
// Cadenas de atributos y llamadas que usan miembros heredados del receptor

class A1 {
    B2 a1;
    int a2;

    B2 getB() {
        return a1;
    }
}

class B2 extends A1 {
    A1 a3;

    void m1(B2 p1) {
        a1.a3.a2 = 4;
        p1.a1.a1.a3 = p1;
        p1.getB().a3.a2 = p1.a2 + a1.a2;
        var x = p1.getB().getB().a2;
        x = a3.getB().a3.a2;
    }
}

class Init{
    static void main()
    { }
}
