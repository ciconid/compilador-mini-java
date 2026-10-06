///[SinErrores]
// Un metodo con el mismo nombre que uno final heredado pero distinta aridad no lo redefine

class A1{
    final void m()
    {}
}

class B2 extends A1{
    void m(int x)
    {}
}

class Init{
    static void main()
    { }
}
