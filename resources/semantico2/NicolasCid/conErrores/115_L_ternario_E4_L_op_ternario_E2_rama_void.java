///[Error:?|8]
// Una rama void no produce un valor

class A1 {
    void m2() {}

    void m1(boolean b) {
        var y = b ? m2() : 1;
    }
}

class Init{
    static void main()
    { }
}
