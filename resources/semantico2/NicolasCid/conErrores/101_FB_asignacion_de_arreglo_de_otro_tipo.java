///[Error:=|7]
// char[] no conforma con int[]

class A1 {
    void m1() {
        var v = new int[3];
        v = new char[3];
    }
}

class Init{
    static void main()
    { }
}
