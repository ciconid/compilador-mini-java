///[SinErrores]
// Tipos genericos anidados en atributos, retornos y parametros

class Caja<T>{
}

class Lista<T>{
}

class Nodo{
}

class A1{
    Caja<Lista<String>> x;

    Caja<Lista<Nodo>> m(Lista<Caja<String>> p)
    {}
}

class Init{
    static void main()
    { }
}
