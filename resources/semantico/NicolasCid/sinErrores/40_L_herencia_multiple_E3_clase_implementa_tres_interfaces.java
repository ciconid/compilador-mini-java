///[SinErrores]
// Clase que implementa tres interfaces

interface I1{
    void m();
}

interface I2{
    void n();
}

interface I3{
    void o();
}

class A1 implements I1, I2, I3{
    void m()
    {}

    void n()
    {}

    void o()
    {}
}

class Init{
    static void main()
    { }
}
