///[Error:I1|9]
// No se pueden crear instancias de una interfaz

interface I1 {
}

class A1 {
    void m1() {
        var x = new I1();
    }
}

class Init{
    static void main()
    { }
}
