///[Error:extends|7]
// En una interfaz, permits va despues de extends

interface J2{
}

sealed interface I1 permits C3 extends J2{
}

final class C3 implements I1{
}

class Init{
    static void main()
    { }
}
