///[SinErrores]
// Redefinicion con la misma signatura

class A1{
    int m(char c, boolean b)
    {}
}

class B2 extends A1{
    int m(char c, boolean b)
    {}
}

class Init{
    static void main()
    { }
}
