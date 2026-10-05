///[Error:m|16]
// Redefinicion incorrecta luego de instanciar T con Lista<String>

class Caja<T>{
    T m()
    {}
}

class Lista<T>{
}

class Nodo{
}

class A1 extends Caja<Lista<String>>{
    Lista<Nodo> m()
    {}
}

class Init{
    static void main()
    { }
}
