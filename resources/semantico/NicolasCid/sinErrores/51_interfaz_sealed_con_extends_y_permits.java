///[SinErrores]
// En una interfaz, permits va despues de extends

interface K3{
}

sealed interface I1 extends K3 permits C3{
}

final class C3 implements I1{
}

class Init{
    static void main()
    { }
}
