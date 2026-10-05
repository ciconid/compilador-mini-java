///[Error:Foo|11]
// Tipo de retorno con un argumento anidado no declarado

class Caja<T>{
}

class Lista<T>{
}

class A1{
    Caja<Lista<Foo>> m()
    {}
}

class Init{
    static void main()
    { }
}
