///[Error:m2|11]
// Object no conforma con A1, el tipo del parametro del metodo heredado

class A1 {
    void m2(A1 a) {
    }
}

class B2 extends A1 {
    void m1(Object o) {
        m2(o);
    }
}

class Init{
    static void main()
    { }
}
