///[Error:m|19]
// Redefinicion con distinto argumento anidado en el tipo de retorno

class Caja<T>{
}

class Lista<T>{
}

class Nodo{
}

class A1{
    Caja<Lista<String>> m()
    {}
}

class B2 extends A1{
    Caja<Lista<Nodo>> m()
    {}
}

class Init{
    static void main()
    { }
}
