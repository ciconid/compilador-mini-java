///[Error:Nodo|11]
// Clase no generica usada con argumento dentro de un tipo anidado

class Caja<T>{
}

class Nodo{
}

class A1{
    Caja<Nodo<String>> x;
}

class Init{
    static void main()
    { }
}
