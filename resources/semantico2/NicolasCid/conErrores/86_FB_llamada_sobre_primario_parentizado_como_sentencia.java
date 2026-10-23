///[Error:;|9]
// Un primario parentizado no puede ser la base de una sentencia de llamada

class A1 {
    void m2() {}

    void m1(A1 a) {
        a.m2();
        (a).m2();
    }
}

class Init{
    static void main()
    { }
}
