///[Error:B2|7]
// La subclase de una clase sealed debe ser final, sealed o non-sealed

sealed class A1 permits B2{
}

class B2 extends A1{
}

class Init{
    static void main()
    { }
}
