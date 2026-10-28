///[SinErrores]
// En un estatico un parametro puede ocultar a un atributo, y los miembros de instancia se alcanzan con receptores
// explicitos (local, llamada o creacion); un estatico heredado se llama sin receptor o con el nombre de la subclase

class A1 {
    int a1;

    int m2() {
        return a1;
    }

    static A1 crear() {
        return new A1();
    }

    static void est() {
    }

    static void m1(int a1) {
        a1 = 3;
        var a = new A1();
        a.a1 = a1;
        a1 = a.m2();
        a1 = crear().a1;
        crear().m2();
        a1 = new A1().m2();
        new A1().a1 = 2;
    }
}

class B2 extends A1 {
    static void m3() {
        est();
        B2.est();
        var b = B2.crear();
        b.a1 = 1;
    }
}

class Init{
    static void main()
    { }
}
