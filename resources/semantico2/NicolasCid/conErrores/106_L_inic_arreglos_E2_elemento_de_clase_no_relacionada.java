///[Error:{|9]
// B1 no conforma con A1

class B1 {
}

class A1 {
    void m1() {
        var v = new A1[]{new A1(), new B1()};
    }
}

class Init{
    static void main()
    { }
}
