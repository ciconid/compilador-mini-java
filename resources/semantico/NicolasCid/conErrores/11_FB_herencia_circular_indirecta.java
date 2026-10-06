///[Error:A1|4]
// Ciclo de herencia A1 -> B2 -> C3 -> A1

class A1 extends B2{
}

class B2 extends C3{
}

class C3 extends A1{
}

class Init{
    static void main()
    { }
}
