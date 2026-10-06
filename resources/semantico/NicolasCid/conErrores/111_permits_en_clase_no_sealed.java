///[Error:permits|4]
// Solo una clase sealed puede tener permits

class A1 permits B2{
}

final class B2 extends A1{
}

class Init{
    static void main()
    { }
}
