///[Error:=|13]
// Una interfaz conforma con las que extiende, pero no al reves

interface I1 {
}

interface I2 extends I1 {
}

class A1 {
    void m1(I1 i1, I2 i2) {
        i1 = i2;
        i2 = i1;
    }
}

class Init{
    static void main()
    { }
}
