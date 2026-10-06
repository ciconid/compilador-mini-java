///[Error:C3|4]
// Las clases de permits deben estar declaradas

sealed class A1 permits B2, C3{
}

final class B2 extends A1{
}

class Init{
    static void main()
    { }
}
