///[SinErrores]
// El tipo de un ternario es el de la rama mas general

class A1 {
}

class B1 extends A1 {
}

class C1 {
    int m2(int p) {
        return p;
    }

    void m1(boolean b, int x) {
        var n = b ? 1 : 2;
        var s = b ? "a" : null;
        s = b ? null : "b";
        var a = b ? new B1() : new A1();
        a = b ? new A1() : new B1();
        n = x < 3 ? x : 3;
        var c = b ? 'a' : 'b';
        var bb = b ? b : !b;
        n = (b ? 1 : 2) + 3;
        n = b ? 1 : x > 0 ? 2 : 3;
        n = m2(b ? n : x);
        var o = b ? new Object() : a;
    }
}

class Init{
    static void main()
    { }
}
