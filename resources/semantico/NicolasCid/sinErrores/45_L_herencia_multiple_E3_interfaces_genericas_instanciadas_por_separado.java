///[SinErrores]
// Cada interfaz generica implementada se instancia con su propio argumento

interface I1<T>{
    T m();
}

interface I2<T>{
    void n(T x);
}

class Nodo{
}

class A1 implements I1<String>, I2<Nodo>{
    String m()
    {}

    void n(Nodo x)
    {}
}

class Init{
    static void main()
    { }
}
