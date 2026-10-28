///[Error:=|7]
// this no es un destino asignable

class A1 {
    void m1(A1 otro) {
        otro = this;
        this = otro;
    }
}

class Init{
    static void main()
    { }
}
