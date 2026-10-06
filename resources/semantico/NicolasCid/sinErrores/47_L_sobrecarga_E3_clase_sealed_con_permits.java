///[SinErrores]
// Clase sealed con permits y subclases final y non-sealed

sealed class A1 permits B2, C3{
}

final class B2 extends A1{
}

non-sealed class C3 extends A1{
}

class Init{
    static void main()
    { }
}
