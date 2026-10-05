///[SinErrores]
// Clase que implementa los metodos de su interfaz y de la super-interfaz

interface I1{
    void m();
}

interface I2 extends I1{
    void n();
}

class A1 implements I2{
    void m()
    {}

    void n()
    {}
}

class Init{
    static void main()
    { }
}
