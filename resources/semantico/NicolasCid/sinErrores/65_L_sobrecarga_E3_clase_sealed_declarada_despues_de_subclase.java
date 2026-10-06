///[SinErrores]
// El orden de declaracion no importa para sealed y permits

final class B2 extends A1{
}

sealed class A1 permits B2{
}

class Init{
    static void main()
    { }
}
