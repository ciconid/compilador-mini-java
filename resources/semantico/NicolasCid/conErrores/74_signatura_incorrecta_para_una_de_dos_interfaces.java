///[Error:m|13]
// Metodo con signatura incorrecta para una de las dos interfaces

interface I1{
    void m(int a);
}

interface I2{
    void n();
}

class A1 implements I1, I2{
    void m(char a)
    {}

    void n()
    {}
}

class Init{
    static void main()
    { }
}
