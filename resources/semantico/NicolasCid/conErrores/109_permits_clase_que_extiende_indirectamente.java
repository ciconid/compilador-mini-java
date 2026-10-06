///[Error:C3|4]
// Las clases de permits deben extender directamente a la clase sealed

sealed class A1 permits B2, C3{
}

non-sealed class B2 extends A1{
}

final class C3 extends B2{
}

class Init{
    static void main()
    { }
}
