///[Error:Z9|9]
// El argumento generico de un new tiene que estar declarado

class Caja<T> {
}

class A1 {
    void m1() {
        var c = new Caja<Z9>();
    }
}

class Init{
    static void main()
    { }
}
