///[Error:Lista|11]
// Una clase generica sin argumento no puede usarse como argumento de otra (seria un tipo raw)

class Caja<T>{
}

class Lista<T>{
}

class A1{
    Caja<Lista> x;
}

class Init{
    static void main()
    { }
}
