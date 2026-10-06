///[Error:A1|7]
// Una clase que implementa una interfaz sealed debe ser final, sealed o non-sealed

sealed interface I1 permits A1{
}

class A1 implements I1{
}

class Init{
    static void main()
    { }
}
