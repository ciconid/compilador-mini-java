///[Error:A1|10]
// Una clase que no esta en permits no puede extender la clase sealed

sealed class A1 permits B2{
}

final class B2 extends A1{
}

final class C3 extends A1{
}

class Init{
    static void main()
    { }
}
