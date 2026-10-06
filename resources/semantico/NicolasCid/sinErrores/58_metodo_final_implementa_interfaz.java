///[SinErrores]
// Un metodo final puede implementar un metodo de interfaz

interface I1{
    void m();
}

class A1 implements I1{
    final void m()
    {}
}

class Init{
    static void main()
    { }
}
