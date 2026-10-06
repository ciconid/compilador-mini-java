///[SinErrores]
// Interfaz sealed generica implementada por una clase permitida

class C3{
}

sealed interface I1<T> permits A1{
    void m(T x);
}

final class A1 implements I1<C3>{
    void m(C3 x)
    {}
}

class Init{
    static void main()
    { }
}
