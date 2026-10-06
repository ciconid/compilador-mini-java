///[Error:Nodo|10]
// Herencia con un argumento anidado de una clase no generica

class Caja<T>{
}

class Nodo{
}

class B2 extends Caja<Nodo<String>>{
}

class Init{
    static void main()
    { }
}
