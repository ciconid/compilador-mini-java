///[SinErrores]
// Implementacion de interfaz generica instanciada con un anidado

interface I1<T>{
    T m(T x);
}

class Caja<T>{
}

class A1 implements I1<Caja<String>>{
    Caja<String> m(Caja<String> x)
    {}
}

class Init{
    static void main()
    { }
}
