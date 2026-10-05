///[Error:I1|7]
// La misma interfaz aparece dos veces en implements

interface I1{
}

class A1 implements I1, I1{
}

class Init{
    static void main()
    { }
}
