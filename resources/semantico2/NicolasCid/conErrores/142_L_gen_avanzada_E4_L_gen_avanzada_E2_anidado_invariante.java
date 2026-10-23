///[Error:=|9]
// Los genericos son invariantes tambien en el nivel anidado

class Caja<T> {
}

class A1 {
    void m1(Caja<Caja<String>> cs, Caja<Caja<Object>> co) {
        co = cs;
    }
}

class Init{
    static void main()
    { }
}
