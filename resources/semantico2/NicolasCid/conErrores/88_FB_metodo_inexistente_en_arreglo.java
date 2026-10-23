///[Error:clone|7]
// Los arreglos solo tienen length y toString()

class A1 {
    void m1(int[] v) {
        var s = v.toString();
        v.clone();
    }
}

class Init{
    static void main()
    { }
}
