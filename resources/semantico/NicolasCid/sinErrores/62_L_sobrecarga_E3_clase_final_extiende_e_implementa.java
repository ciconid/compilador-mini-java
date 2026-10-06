///[SinErrores]
// Una clase final puede extender una clase e implementar interfaces

interface I1{
    void m();
}

class P1{
}

final class A1 extends P1 implements I1{
    void m()
    {}
}

class Init{
    static void main()
    { }
}
