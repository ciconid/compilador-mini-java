///[Error:Z9|6]
// La clase de una llamada estatica tiene que existir

class A1 {
    void m1() {
        Z9.m2();
    }
}

class Init{
    static void main()
    { }
}
