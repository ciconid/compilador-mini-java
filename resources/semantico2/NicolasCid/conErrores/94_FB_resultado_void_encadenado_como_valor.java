///[Error:r|10]
// Una llamada encadenada void no produce un valor

class B1 {
    void m2() {}
}

class A1 {
    void m1(B1 b) {
        var r = b.m2();
    }
}

class Init{
    static void main()
    { }
}
