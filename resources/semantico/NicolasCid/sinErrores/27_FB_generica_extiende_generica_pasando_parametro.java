///[SinErrores]
// Clase generica que pasa su parametro de tipo a la clase padre

class Caja<T>{
    T m()
    {}
}

class A1<U> extends Caja<U>{
    U m()
    {}
}

class Init{
    static void main()
    { }
}
