///[Error:[|6]
// El indice de un acceso a arreglo tiene que ser int

class A1 {
    void m1(int[] v) {
        v[true] = 1;
    }
}

class Init{
    static void main()
    { }
}
