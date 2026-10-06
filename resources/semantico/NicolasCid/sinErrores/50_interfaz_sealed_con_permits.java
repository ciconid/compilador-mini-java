///[SinErrores]
// Interfaz sealed con permits, implementada por una clase final y extendida por una interfaz non-sealed

sealed interface I1 permits C3, J2{
}

final class C3 implements I1{
}

non-sealed interface J2 extends I1{
}

class Init{
    static void main()
    { }
}
