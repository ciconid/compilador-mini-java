///[Error:=|10]
// Una llamada encadenada no es asignable

class A1 {
    int m2() {
        return 1;
    }

    void m1(A1 a) {
        a.m2() = 3;
    }
}

class Init{
    static void main()
    { }
}
