///[Error:=|7]
// El ternario tiene tipo String y no conforma con int

class A1 {
    void m1(boolean b) {
        var n = 0;
        n = b ? "a" : "b";
    }
}

class Init{
    static void main()
    { }
}
