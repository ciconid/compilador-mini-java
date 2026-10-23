///[Error:=|7]
// length es de solo lectura

class A1 {
    void m1(int[] v) {
        var n = v.length;
        v.length = 3;
    }
}

class Init{
    static void main()
    { }
}
