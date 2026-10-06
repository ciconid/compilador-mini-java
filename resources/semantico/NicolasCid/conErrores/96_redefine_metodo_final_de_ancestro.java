///[Error:m|13]
// No se puede redefinir un metodo final heredado de un ancestro indirecto

class A1{
    final void m()
    {}
}

class B2 extends A1{
}

class C3 extends B2{
    void m()
    {}
}

class Init{
    static void main()
    { }
}
