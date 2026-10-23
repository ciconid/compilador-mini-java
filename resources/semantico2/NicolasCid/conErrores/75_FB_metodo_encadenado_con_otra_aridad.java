///[Error:m2|10]
// El metodo m2 de B1 no tiene parametros

class B1 {
    void m2() {}
}

class A1 {
    void m1(B1 b) {
        b.m2(1);
    }
}

class Init{
    static void main()
    { }
}
