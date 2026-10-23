///[Error:{|6]
// Los elementos de un int[][] son int[], y 1 no conforma

class A1 {
    void m1() {
        var m = new int[][]{1, {2}};
    }
}

class Init{
    static void main()
    { }
}
