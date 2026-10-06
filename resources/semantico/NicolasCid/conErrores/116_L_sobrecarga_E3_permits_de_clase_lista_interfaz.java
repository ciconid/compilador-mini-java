///[Error:I1|4]
// Una interfaz no puede estar en el permits de una clase

sealed class A1 permits B2, I1{
}

final class B2 extends A1{
}

interface I1{
}

class Init{
    static void main()
    { }
}
