///[SinErrores]
// Un primario parentizado puede ser la base de un encadenado usado como valor

class A1 {
    int x;

    A1 m2() {
        return this;
    }

    void m1(A1 a, int[] v) {
        var n = (a).x;
        var b = (a).m2();
        n = (b.m2()).x + (v)[0];
        b.m2().m2().x = (v).length;
    }
}

class Init{
    static void main()
    { }
}
