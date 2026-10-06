///[Error:m|10]
// Redefinicion con distinto tipo de parametro

class A1{
    void m(int a)
    {}
}

class B2 extends A1{
    void m(char a)
    {}
}

class Init{
    static void main()
    { }
}
