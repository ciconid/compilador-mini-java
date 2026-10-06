///[SinErrores]
// Clase generica que pasa a su padre un anidado con su parametro de tipo

class Caja<T>{
    T m(T x)
    {}
}

class Lista<T>{
}

class A1<U> extends Caja<Lista<U>>{
    Lista<U> m(Lista<U> x)
    {}
}

class Init{
    static void main()
    { }
}
