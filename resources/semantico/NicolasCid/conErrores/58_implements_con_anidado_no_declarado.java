///[Error:Foo|10]
// Implementacion con un argumento anidado no declarado

interface I1<T>{
}

class Lista<T>{
}

class A1 implements I1<Lista<Foo>>{
}

class Init{
    static void main()
    { }
}
