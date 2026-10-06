///[SinErrores]
// Redefinicion con los mismos tipos anidados

class Caja<T>{
}

class Lista<T>{
}

class Nodo{
}

class A1{
    Caja<Lista<String>> m(Lista<Nodo> p)
    {}
}

class B2 extends A1{
    Caja<Lista<String>> m(Lista<Nodo> p)
    {}
}

class Init{
    static void main()
    { }
}
