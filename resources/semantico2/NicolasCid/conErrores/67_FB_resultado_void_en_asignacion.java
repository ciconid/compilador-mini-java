///[Error:=|8]
// Una llamada void no puede ser el lado derecho de una asignacion

class A1 {
    int a1;

    void m1() {
        a1 = m2();
    }

    void m2() {
    }
}

class Init{
    static void main()
    { }
}
