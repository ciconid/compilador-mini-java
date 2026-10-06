///[SinErrores]
// Una subclase de una clase sealed puede ser sealed a su vez

sealed class A1 permits B2{
}

sealed class B2 extends A1 permits C3{
}

final class C3 extends B2{
}

class Init{
    static void main()
    { }
}
