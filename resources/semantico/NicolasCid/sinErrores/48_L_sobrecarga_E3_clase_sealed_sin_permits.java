///[SinErrores]
// Clase sealed sin permits: cualquier clase del programa puede extenderla

sealed class A1{
}

final class B2 extends A1{
}

class Init{
    static void main()
    { }
}
