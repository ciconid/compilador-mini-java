///[Error:=|10]
// Sin tipo esperado, el diamante se infiere como Caja<Object>, que no conforma con Caja<String>

class Caja<T> {
}

class A1 {
    void m1(Caja<String> s) {
        var c = new Caja<>();
        s = c;
    }
}

class Init{
    static void main()
    { }
}
