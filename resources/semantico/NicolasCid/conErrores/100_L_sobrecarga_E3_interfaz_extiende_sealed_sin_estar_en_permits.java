///[Error:I1|10]
// Una interfaz que no esta en permits no puede extender la interfaz sealed

sealed interface I1 permits A1{
}

final class A1 implements I1{
}

non-sealed interface J2 extends I1{
}

class Init{
    static void main()
    { }
}
