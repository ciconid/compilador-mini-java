///[Error:m2|6]
// El segundo argumento (int) no conforma con el parametro formal (boolean)

class A1 {
    void m1() {
        m2(1, 2);
    }

    void m2(int x, boolean b) {
    }
}

class Init{
    static void main()
    { }
}
