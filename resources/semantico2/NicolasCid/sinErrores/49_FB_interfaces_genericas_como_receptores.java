///[SinErrores]
// Los metodos de una interfaz generica se ven desde el receptor, tambien a traves de una interfaz que la extiende

interface I1<T> {
    T obtener();

    void poner(T x);
}

interface I2 extends I1<String> {
}

class Impl implements I2 {
    String obtener() {
        return "a";
    }

    void poner(String x) {
    }
}

class A1 {
    void m1(I1<A1> i, I2 j, Impl k, I1<String> l) {
        var a = i.obtener();
        a.m1(i, j, k, l);
        i.poner(new A1());
        var s = j.obtener();
        j.poner(s);
        s = k.obtener();
        j = k;
        l = j;
        l = k;
        l.poner(l.obtener());
    }
}

class Init{
    static void main()
    { }
}
