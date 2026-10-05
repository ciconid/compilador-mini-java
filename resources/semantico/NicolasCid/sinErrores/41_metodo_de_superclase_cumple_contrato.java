///[SinErrores]
// extends + implements: un metodo heredado de la superclase cumple el contrato

interface I1{
    void m();
}

class B2{
    void m()
    {}
}

class A1 extends B2 implements I1{
}

class Init{
    static void main()
    { }
}
