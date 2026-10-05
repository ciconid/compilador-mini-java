///[Error:A1|12]
// Clase que no implementa un metodo heredado por su interfaz

interface I1{
    void m();
}

interface I2 extends I1{
    void n();
}

class A1 implements I2{
    void n()
    {}
}

class Init{
    static void main()
    { }
}
