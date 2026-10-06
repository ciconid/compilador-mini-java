///[Error:Foo|11]
// Parametro con un argumento anidado no declarado

class Caja<T>{
}

class Lista<T>{
}

class A1{
    void m(Caja<Lista<Foo>> p)
    {}
}

class Init{
    static void main()
    { }
}
