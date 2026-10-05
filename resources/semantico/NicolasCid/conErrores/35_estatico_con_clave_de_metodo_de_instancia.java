///[Error:m|10]
// Metodo estatico con la clave de un metodo de instancia heredado

class A1{
    void m()
    {}
}

class B2 extends A1{
    static void m()
    {}
}

class Init{
    static void main()
    { }
}
