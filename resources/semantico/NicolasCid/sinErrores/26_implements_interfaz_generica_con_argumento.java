///[SinErrores]
// Implementacion de interfaz generica instanciada

interface I1<T>{
    T m(T x);
}

class A1 implements I1<String>{
    String m(String x)
    {}
}

class Init{
    static void main()
    { }
}
