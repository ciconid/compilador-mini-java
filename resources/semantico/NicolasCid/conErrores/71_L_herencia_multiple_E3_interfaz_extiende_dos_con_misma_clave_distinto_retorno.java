///[Error:I3|12]
// Interfaz que extiende dos interfaces con la misma clave y distinto retorno

interface I1{
    void m();
}

interface I2{
    int m();
}

interface I3 extends I1, I2{
}

class Init{
    static void main()
    { }
}
