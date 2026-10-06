///[Error:<|7]
// En permits van nombres de clase, sin argumentos genericos

class C3{
}

sealed class A1<T> permits B2<C3>{
}

final class B2 extends A1<C3>{
}

class Init{
    static void main()
    { }
}
