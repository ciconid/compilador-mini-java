///[SinErrores]
// Llamadas sin receptor a metodos propios y heredados, sobrecarga por aridad y recursion

class A1 {
    int m1() {
        return m1(1);
    }

    int m1(int x) {
        return x;
    }
}

class B2 extends A1 {
    boolean m2(boolean b) {
        var x = m1() + m1(2);
        if (x > 0) {
            return m2(!b);
        }
        return b;
    }
}

class Init{
    static void main()
    { }
}
