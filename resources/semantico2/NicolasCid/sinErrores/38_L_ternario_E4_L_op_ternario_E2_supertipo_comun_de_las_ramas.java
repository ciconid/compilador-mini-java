///[SinErrores]
// Como en Java, el tipo de un ternario con ramas referencia es el supertipo comun mas especifico

interface I1 {
    void deI();
}

class A1 {
    void deA() {}
}

class B1 extends A1 {
}

class C1 extends A1 {
}

class D1 implements I1 {
    void deI() {}
}

class E1 implements I1 {
    void deI() {}
}

class F1 {
    void m1(boolean b) {
        var y = b ? new B1() : new C1();
        y.deA();
        y = new A1();
        var i = b ? new D1() : new E1();
        i.deI();
        var o = b ? new A1() : new D1();
        o = "hola";
        var w = b ? new int[1] : new A1();
        w = new Object();
        var s = b ? new B1() : new A1();
        s = new C1();
    }
}

class Init{
    static void main()
    { }
}
