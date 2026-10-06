///[SinErrores]
// Interfaz que extiende dos interfaces, implementada completamente

interface I1{
    void m();
}

interface I2{
    void n();
}

interface I3 extends I1, I2{
    void o();
}

class A1 implements I3{
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
