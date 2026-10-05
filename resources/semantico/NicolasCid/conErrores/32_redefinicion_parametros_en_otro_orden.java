///[Error:m|10]
// Redefinicion con los parametros en otro orden

class A1{
    void m(int a, char b)
    {}
}

class B2 extends A1{
    void m(char b, int a)
    {}
}

class Init{
    static void main()
    { }
}
