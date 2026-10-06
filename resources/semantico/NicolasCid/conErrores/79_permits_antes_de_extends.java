///[Error:extends|7]
// permits va despues de extends

class C3{
}

sealed class A1 permits B2 extends C3{
}

final class B2 extends A1{
}

class Init{
    static void main()
    { }
}
