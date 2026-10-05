///[SinErrores]
// Tipo generico anidado de tres niveles

class Caja<T>{
}

class Lista<T>{
}

class Nodo{
}

class A1{
    Caja<Lista<Caja<Nodo>>> x;
}

class Init{
    static void main()
    { }
}
