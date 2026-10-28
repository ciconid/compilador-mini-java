///[Error:B2|14]
// Los constructores no se buscan en ancestros: B2 solo tiene el constructor por defecto

class A1 {
    public A1(int x) {
    }
}

class B2 extends A1 {
}

class Uso {
    void m1() {
        new B2(3);
    }
}

class Init{
    static void main()
    { }
}
