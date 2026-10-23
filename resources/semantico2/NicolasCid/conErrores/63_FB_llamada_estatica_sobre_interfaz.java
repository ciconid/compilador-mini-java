///[Error:I1|10]
// En Clase.m(...), Clase tiene que nombrar una clase, no una interfaz

interface I1 {
    void m2();
}

class A1 {
    void m1() {
        I1.m2();
    }
}

class Init{
    static void main()
    { }
}
