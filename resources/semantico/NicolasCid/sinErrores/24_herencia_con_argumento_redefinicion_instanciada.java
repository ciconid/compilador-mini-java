///[SinErrores]
// Redefinicion correcta luego de instanciar T con String

class Caja<T>{
    T m(T x)
    {}
}

class A1 extends Caja<String>{
    String m(String x)
    {}
}

class Init{
    static void main()
    { }
}
