///[Error:m|10]
// Redefinicion con distinto tipo de retorno

class A1{
    void m()
    {}
}

class B2 extends A1{
    int m()
    {}
}

class Init{
    static void main()
    { }
}
