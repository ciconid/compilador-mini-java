///[Error:return|6]
// El resultado de una llamada void no conforma con el tipo de retorno int

class A1 {
    int m1() {
        return m2();
    }

    void m2() {
    }
}

class Init{
    static void main()
    { }
}
