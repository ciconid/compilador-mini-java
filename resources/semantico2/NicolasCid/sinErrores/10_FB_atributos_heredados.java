///[SinErrores]
// Los atributos heredados se resuelven igual que los propios

class A1 {
    int a1;
}

class B2 extends A1 {
    boolean b1;

    void m1() {
        a1 = 3;
        b1 = a1 > 2;
    }
}

class C3 extends B2 {
    int m2() {
        b1 = true;
        return a1;
    }
}

class Init{
    static void main()
    { }
}
