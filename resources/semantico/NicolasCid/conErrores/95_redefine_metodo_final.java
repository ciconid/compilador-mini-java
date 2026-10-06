///[Error:m|10]
// No se puede redefinir un metodo final

class A1{
    final void m()
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
