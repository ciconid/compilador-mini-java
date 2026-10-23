///[SinErrores]
// Un arreglo conforma con un arreglo identico y con Object; null conforma con arreglos

class A1 {
    void m1(int[] a, String[][] s, String[][] t, Object o) {
        o = a;
        o = s;
        t = s;
        s = null;
    }

    boolean m2(int[] a, int[] b) {
        return (a == b) && (a != null);
    }
}

class Init{
    static void main()
    { }
}
