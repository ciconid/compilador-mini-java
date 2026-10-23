///[Error:A1|6]
// No se puede suministrar un argumento generico a una clase no generica

class A1 {
    void m1() {
        var a = new A1<String>();
    }
}

class Init{
    static void main()
    { }
}
