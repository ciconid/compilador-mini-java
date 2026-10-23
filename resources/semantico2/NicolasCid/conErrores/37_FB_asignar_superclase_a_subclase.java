///[Error:=|9]
// Una superclase no conforma con su subclase

class A1 {
}

class B2 extends A1 {
    void m1(A1 a, B2 b) {
        b = a;
    }
}

class Init{
    static void main()
    { }
}
