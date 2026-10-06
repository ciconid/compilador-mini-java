///[Error:I1|10]
// Una clase que no esta en permits no puede implementar la interfaz sealed

sealed interface I1 permits A1{
}

final class A1 implements I1{
}

final class B2 implements I1{
}

class Init{
    static void main()
    { }
}
