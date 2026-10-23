///[Error:+|6]
// Una llamada a un metodo void no produce un valor utilizable como operando

class A1 {
    int m1() {
        return m2() + 1;
    }

    void m2() {
    }
}

class Init{
    static void main()
    { }
}
