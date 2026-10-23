///[Error:[|7]
// v[0] es int y no se puede volver a indexar

class A1 {
    void m1(int[] v) {
        v[0] = 2;
        v[0][1] = 2;
    }
}

class Init{
    static void main()
    { }
}
