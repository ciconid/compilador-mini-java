///[Error:I1|7]
// La misma interfaz aparece dos veces en el extends de una interfaz

interface I1{
}

interface I3 extends I1, I1{
}

class Init{
    static void main()
    { }
}
