///[Error:x|6]
// Una llamada void no permite inferir el tipo de una variable local

class A1 {
    void m1() {
        var x = m2();
    }

    void m2() {
    }
}

class Init{
    static void main()
    { }
}
