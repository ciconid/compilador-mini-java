///[SinErrores]
// Parametro de tipo usado dentro de tipos anidados

class Lista<T>{
}

class Caja<T>{
    Lista<Caja<T>> x;

    Lista<T> m(Caja<Lista<T>> p)
    {}
}

class Init{
    static void main()
    { }
}
