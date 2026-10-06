///[SinErrores]
// Diamante de interfaces: I1 e I2 extienden I0, I3 extiende I1 e I2

interface I0{
    void m();
}

interface I1 extends I0{
    void n();
}

interface I2 extends I0{
    void o();
}

interface I3 extends I1, I2{
}

class A1 implements I3{
    void m()
    {}

    void n()
    {}

    void o()
    {}
}

class Init{
    static void main()
    { }
}
