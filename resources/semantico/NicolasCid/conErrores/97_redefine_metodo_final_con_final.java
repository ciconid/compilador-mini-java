///[Error:m|10]
// Redefinir un metodo final es error aunque la redefinicion tambien sea final

class A1{
    final int m()
    {}
}

class B2 extends A1{
    final int m()
    {}
}

class Init{
    static void main()
    { }
}
