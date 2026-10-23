///[Error:poner|11]
// Desde Caja<Caja<String>>, poner espera Caja<String> y no Caja<A1>

class Caja<T> {
    void poner(T p) {}
}

class A1 {
    void m1(Caja<Caja<String>> cc) {
        cc.poner(new Caja<String>());
        cc.poner(new Caja<A1>());
    }
}

class Init{
    static void main()
    { }
}
