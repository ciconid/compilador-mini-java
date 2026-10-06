///[SinErrores]
// La superclase implementa I1 y la subclase agrega I2

interface I1{
    void m();
}

interface I2{
    void n();
}

class B2 implements I1{
    void m()
    {}
}

class A1 extends B2 implements I2{
    void n()
    {}
}

class Init{
    static void main()
    { }
}
