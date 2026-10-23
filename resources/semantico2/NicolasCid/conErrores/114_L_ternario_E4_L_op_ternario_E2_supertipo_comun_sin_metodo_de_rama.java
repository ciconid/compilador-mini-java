///[Error:soloEnB|18]
// El ternario tiene tipo A1 (supertipo comun de B1 y C1), que no tiene el metodo soloEnB

class A1 {
}

class B1 extends A1 {
    void soloEnB() {}
}

class C1 extends A1 {
}

class D1 {
    void m1(boolean b) {
        var y = b ? new B1() : new C1();
        y = new A1();
        y.soloEnB();
    }
}

class Init{
    static void main()
    { }
}
