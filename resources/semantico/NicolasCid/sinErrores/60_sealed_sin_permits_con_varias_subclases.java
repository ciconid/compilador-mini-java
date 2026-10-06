///[SinErrores]
// Sin permits, una clase sealed admite subclases final, sealed y non-sealed

sealed class A1{
}

final class B2 extends A1{
}

non-sealed class C3 extends A1{
}

sealed class D4 extends A1{
}

final class E5 extends D4{
}

class Init{
    static void main()
    { }
}
