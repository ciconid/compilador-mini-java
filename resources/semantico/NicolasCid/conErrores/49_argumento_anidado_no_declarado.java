///[Error:Foo|11]
// Argumento generico anidado de un tipo no declarado

class Caja<T>{
}

class Lista<T>{
}

class A1{
    Caja<Lista<Foo>> x;
}

class Init{
    static void main()
    { }
}
