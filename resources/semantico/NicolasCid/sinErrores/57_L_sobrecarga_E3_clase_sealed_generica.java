///[SinErrores]
// Clase sealed generica con permits

class C3{
}

sealed class A1<T> permits B2{
}

final class B2 extends A1<C3>{
}

class Init{
    static void main()
    { }
}
