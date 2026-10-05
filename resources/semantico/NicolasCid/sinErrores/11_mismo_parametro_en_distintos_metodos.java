///[SinErrores]
// Mismo nombre de parametro en distintos metodos y constructores

class A1{
    A1(int a)
    {}

    void m(int a)
    {}

    void n(char a, int b)
    {}
}

class Init{
    static void main()
    { }
}
