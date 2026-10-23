///[SinErrores]
// Una clase conforma con las interfaces que implementa (directa o heredadamente) y sus superinterfaces;
// una interfaz conforma con sus superinterfaces y con Object

interface I1 {
}

interface I2 extends I1 {
}

class A1 implements I2 {
}

class B2 extends A1 {
    void m1(I1 i1, I2 i2, A1 a, B2 b, Object o) {
        i2 = a;
        i1 = a;
        i1 = b;
        i2 = b;
        i1 = i2;
        o = i1;
        o = i2;
    }
}

class Init{
    static void main()
    { }
}
