///[Error:A1|12]
// La clase no implementa el metodo de la segunda interfaz

interface I1{
    void m();
}

interface I2{
    void n();
}

class A1 implements I1, I2{
    void m()
    {}
}

class Init{
    static void main()
    { }
}
