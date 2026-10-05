///[SinErrores]
// Metodos estaticos con claves distintas a las heredadas

class A1{
    static void m()
    {}
}

class B2 extends A1{
    static void m(int a)
    {}

    static void debugPrint()
    {}
}

class Init{
    static void main()
    { }
}
