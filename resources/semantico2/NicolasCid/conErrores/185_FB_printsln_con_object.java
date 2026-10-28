///[Error:printSln|7]
// printSln recibe un String, y Object no conforma con String

class A1 {
    void m1(Object o) {
        System.printSln(o.toString());
        System.printSln(o);
    }
}

class Init{
    static void main()
    { }
}
