///[Error:I1|10]
// La misma interfaz generica implementada dos veces con distintos argumentos

interface I1<T>{
}

class Nodo{
}

class A1 implements I1<String>, I1<Nodo>{
}

class Init{
    static void main()
    { }
}
