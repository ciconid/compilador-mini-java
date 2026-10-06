///[Error:m|9]
// Interfaz que redefine mal un metodo de su super-interfaz

interface I1{
    void m();
}

interface I2 extends I1{
    int m();
}

class Init{
    static void main()
    { }
}
