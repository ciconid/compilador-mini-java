///[Error:m3|6]
// Una llamada void no puede ser un argumento actual

class A1 {
    void m1() {
        m3(m2());
    }

    void m2() {
    }

    void m3(int x) {
    }
}

class Init{
    static void main()
    { }
}
