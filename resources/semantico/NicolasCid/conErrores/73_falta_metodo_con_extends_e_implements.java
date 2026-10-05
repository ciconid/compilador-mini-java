///[Error:A1|11]
// extends + implements: falta un metodo de la interfaz

interface I1{
    void m();
}

class B2{
}

class A1 extends B2 implements I1{
}

class Init{
    static void main()
    { }
}
