///[SinErrores]
// Indexacion, length y toString() de arreglos, y encadenados sobre sus elementos

class A1 {
    int x;

    void m2() {}

    void m1(int[] v, A1[] w, int[][] mat) {
        v[0] = v.length;
        v[v[1]] = w[0].x + 1;
        var s = v.toString();
        s = mat.toString();
        w[0].x = 1;
        w[1].m2();
        mat[0][1] = mat[0].length;
        mat[1] = v;
        var fila = mat[0];
        fila[0] = mat.length;
    }
}

class Init{
    static void main()
    { }
}
