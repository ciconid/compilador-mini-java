///[SinErrores]
// Atributo con el mismo nombre que un metodo heredado

class A1{
    void m()
    {}
}

class B2 extends A1{
    int m;
}

class Init{
    static void main()
    { }
}
