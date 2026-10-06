///[Error:{|4]
// permits con coma final

sealed class A1 permits B2, {
}

final class B2 extends A1{
}

class Init{
    static void main()
    { }
}
