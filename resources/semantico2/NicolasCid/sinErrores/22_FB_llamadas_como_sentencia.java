///[SinErrores]
// Una llamada es valida como sentencia; si produce un valor, se descarta

class A1 {
    void m1() {
        m2();
        m3();
        A1.m4();
        return;
    }

    void m2() {
    }

    int m3() {
        return 1;
    }

    static boolean m4() {
        return true;
    }
}

class Init{
    static void main()
    { }
}
