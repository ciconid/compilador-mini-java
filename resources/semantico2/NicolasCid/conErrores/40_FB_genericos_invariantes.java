///[Error:=|9]
// Los argumentos genericos son invariantes: Caja<String> no conforma con Caja<Object>

class Caja<T> {
}

class A1 {
    void m1(Caja<String> s, Caja<Object> o) {
        o = s;
    }
}

class Init{
    static void main()
    { }
}
