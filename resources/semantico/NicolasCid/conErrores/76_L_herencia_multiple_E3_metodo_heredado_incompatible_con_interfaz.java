///[Error:A1|13]
// Un metodo heredado de la superclase es incompatible con la interfaz

interface I1{
    void m();
}

class B2{
    int m()
    {}
}

class A1 extends B2 implements I1{
}

class Init{
    static void main()
    { }
}
