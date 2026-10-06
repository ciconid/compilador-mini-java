///[SinErrores]
// Una clase non-sealed puede ser extendida por cualquier clase

sealed class A1 permits B2{
}

non-sealed class B2 extends A1{
}

class C3 extends B2{
}

class Init{
    static void main()
    { }
}
