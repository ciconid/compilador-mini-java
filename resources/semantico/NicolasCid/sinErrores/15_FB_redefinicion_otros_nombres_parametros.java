///[SinErrores]
// Redefinicion con distintos nombres de parametros

class A1{
    void m(int a, char b)
    {}
}

class B2 extends A1{
    void m(int x, char y)
    {}
}

class Init{
    static void main()
    { }
}
