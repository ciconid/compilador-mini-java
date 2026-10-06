///[Error:B2|4]
// Una clase no puede aparecer dos veces en permits

sealed class A1 permits B2, B2{
}

final class B2 extends A1{
}

class Init{
    static void main()
    { }
}
