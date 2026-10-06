///[Error:C3|4]
// Las clases de permits deben extender a la clase sealed

sealed class A1 permits B2, C3{
}

final class B2 extends A1{
}

final class C3{
}

class Init{
    static void main()
    { }
}
