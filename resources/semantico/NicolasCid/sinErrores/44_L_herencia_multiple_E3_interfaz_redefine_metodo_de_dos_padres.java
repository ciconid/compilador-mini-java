///[SinErrores]
// Interfaz que redefine correctamente un metodo heredado de sus dos padres

interface I1{
    void m();
}

interface I2{
    void m();
}

interface I3 extends I1, I2{
    void m();
}

class A1 implements I3{
    void m()
    {}
}

class Init{
    static void main()
    { }
}
