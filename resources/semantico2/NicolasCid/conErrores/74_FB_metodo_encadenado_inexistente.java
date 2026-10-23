///[Error:m9|7]
// A1 no tiene un metodo m9

class A1 {
    void m1(A1 a) {
        a.m1(a);
        a.m9();
    }
}

class Init{
    static void main()
    { }
}
