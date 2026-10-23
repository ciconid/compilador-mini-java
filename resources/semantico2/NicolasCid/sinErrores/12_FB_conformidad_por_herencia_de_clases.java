///[SinErrores]
// Una clase conforma con sus ancestros (en varios niveles), con Object y null con cualquier clase

class A1 {
}

class B2 extends A1 {
}

class C3 extends B2 {
    void m1(A1 a, B2 b, C3 c, Object o) {
        a = b;
        a = c;
        b = c;
        o = c;
        o = a;
        a = null;
        o = "hola";
    }

    boolean m2(A1 a, C3 c) {
        return (a == c) && (c != a) && (a != null);
    }
}

class Init{
    static void main()
    { }
}
