///[Error:=|9]
// Una interfaz no conforma con una clase que la implementa

interface I1 {
}

class A1 implements I1 {
    void m1(I1 i, A1 a) {
        a = i;
    }
}

class Init{
    static void main()
    { }
}
