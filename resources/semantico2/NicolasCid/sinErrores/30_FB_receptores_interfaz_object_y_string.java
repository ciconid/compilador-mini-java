///[SinErrores]
// Interfaces, Object y String tambien pueden ser receptores

interface I1 {
    int m();
}

class A1 {
    void m1(I1 i, Object o, String t) {
        var n = i.m();
        var s = o.toString();
        s = t.toString();
        s = "hola".toString();
        s = i.toString();
    }
}

class Init{
    static void main()
    { }
}
