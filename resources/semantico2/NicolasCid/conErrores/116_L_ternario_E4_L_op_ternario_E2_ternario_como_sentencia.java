///[Error:;|14]
// Un ternario no es una sentencia valida, aunque sus ramas sean llamadas

class A1 {
    int m2() {
        return 1;
    }

    int m3() {
        return 2;
    }

    void m1(boolean b) {
        b ? m2() : m3();
    }
}

class Init{
    static void main()
    { }
}
