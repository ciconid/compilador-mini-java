///[Error:m|9]
// Un metodo estatico no implementa un metodo de interfaz

interface I1{
    void m();
}

class A1 implements I1{
    static void m()
    {}
}

class Init{
    static void main()
    { }
}
