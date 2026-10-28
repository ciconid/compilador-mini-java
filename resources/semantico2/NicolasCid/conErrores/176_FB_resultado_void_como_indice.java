///[Error:[|9]
// Una llamada void no produce un valor utilizable como indice

class A1 {
    void m2() {
    }

    void m1(int[] v) {
        var n = v[m2()];
    }
}

class Init{
    static void main()
    { }
}
