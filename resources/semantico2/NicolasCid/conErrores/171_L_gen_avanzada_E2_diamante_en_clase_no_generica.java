///[Error:A1|6]
// El diamante solo puede usarse con una clase generica

class A1 {
    void m1(A1 a) {
        a = new A1<>();
    }
}

class Init{
    static void main()
    { }
}
