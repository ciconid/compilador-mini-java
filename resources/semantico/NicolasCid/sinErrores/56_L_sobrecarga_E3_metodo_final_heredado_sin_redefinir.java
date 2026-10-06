///[SinErrores]
// Una subclase hereda un metodo final sin redefinirlo

class A1{
    final void m()
    {}
}

class B2 extends A1{
    void n()
    {}
}

class Init{
    static void main()
    { }
}
