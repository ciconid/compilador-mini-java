///[Error:=|11]
// Visto desde Caja<String>, dato es String y no conforma con int

class Caja<T> {
    T dato;
}

class A1 {
    void m1(Caja<String> c) {
        var n = 0;
        n = c.dato;
    }
}

class Init{
    static void main()
    { }
}
