///[Error:y|9]
// v[0] es A1 y A1 no tiene un atributo y

class A1 {
    int x;

    void m1(A1[] v) {
        v[0].x = 1;
        v[0].y = 1;
    }
}

class Init{
    static void main()
    { }
}
