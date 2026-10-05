///[Error:Foo|8]
// Tipo no declarado en el nivel mas interno de un anidado de tres niveles

class Caja<T>{
}

class A1{
    Caja<Caja<Caja<Foo>>> x;
}

class Init{
    static void main()
    { }
}
