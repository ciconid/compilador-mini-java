///[Error:x|10]
// Una llamada void no produce un valor sobre el cual encadenar

class A1 {
    int x;

    void m2() {}

    void m1() {
        m2().x = 1;
    }
}

class Init{
    static void main()
    { }
}
