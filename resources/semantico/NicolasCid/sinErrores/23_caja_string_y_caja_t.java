///[SinErrores]
// Tipos genericos con argumento de clase y con parametro de tipo

class Caja<T>{
}

class A1{
    Caja<String> c;
    Caja<A1> d;
}

class B2<U>{
    Caja<U> e;
    Caja<U> m(Caja<String> p)
    {}
}

class Init{
    static void main()
    { }
}
