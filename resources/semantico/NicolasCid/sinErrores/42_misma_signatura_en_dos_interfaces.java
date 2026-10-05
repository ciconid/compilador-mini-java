///[SinErrores]
// El mismo metodo en dos interfaces se implementa una sola vez

interface I1{
    int m(char c);
}

interface I2{
    int m(char c);
}

class A1 implements I1, I2{
    int m(char c)
    {}
}

class Init{
    static void main()
    { }
}
