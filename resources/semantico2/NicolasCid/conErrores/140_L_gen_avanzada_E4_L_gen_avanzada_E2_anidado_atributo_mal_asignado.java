///[Error:=|11]
// Desde Caja<Caja<String>>, dato.dato es String y no conforma con int

class Caja<T> {
    T dato;
}

class A1 {
    void m1(Caja<Caja<String>> cc) {
        var n = 0;
        n = cc.dato.dato;
    }
}

class Init{
    static void main()
    { }
}
