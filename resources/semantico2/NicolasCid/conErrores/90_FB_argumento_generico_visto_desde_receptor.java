///[Error:poner|10]
// Visto desde Caja<String>, el parametro de poner es String y 3 no conforma

class Caja<T> {
    void poner(T p) {}
}

class A1 {
    void m1(Caja<String> c) {
        c.poner(3);
    }
}

class Init{
    static void main()
    { }
}
