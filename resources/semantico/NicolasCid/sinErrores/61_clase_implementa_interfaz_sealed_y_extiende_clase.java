///[SinErrores]
// Una clase permitida por una interfaz sealed puede extender otra clase

sealed interface I1 permits A1{
}

class P1{
}

final class A1 extends P1 implements I1{
}

class Init{
    static void main()
    { }
}
