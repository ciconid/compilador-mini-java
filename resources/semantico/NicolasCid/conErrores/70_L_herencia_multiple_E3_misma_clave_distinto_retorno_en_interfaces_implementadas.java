///[Error:A1|12]
// Dos interfaces implementadas con la misma clave y distinto retorno

interface I1{
    void m();
}

interface I2{
    int m();
}

class A1 implements I1, I2{
}

class Init{
    static void main()
    { }
}
