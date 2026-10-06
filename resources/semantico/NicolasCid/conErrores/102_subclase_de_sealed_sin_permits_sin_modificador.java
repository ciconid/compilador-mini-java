///[Error:B2|7]
// La subclase de una clase sealed sin permits tambien debe tener modificador

sealed class A1{
}

class B2 extends A1{
}

class Init{
    static void main()
    { }
}
