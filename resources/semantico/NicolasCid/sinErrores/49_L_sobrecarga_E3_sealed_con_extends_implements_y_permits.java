///[SinErrores]
// permits va despues de extends e implements

interface I1{
    void m();
}

class P1{
}

sealed class A1 extends P1 implements I1 permits B2{
    void m()
    {}
}

final class B2 extends A1{
}

class Init{
    static void main()
    { }
}
