///[Error:m|10]
// Metodo de instancia con la clave de un estatico heredado

class A1{
    static void m()
    {}
}

class B2 extends A1{
    void m()
    {}
}

class Init{
    static void main()
    { }
}
