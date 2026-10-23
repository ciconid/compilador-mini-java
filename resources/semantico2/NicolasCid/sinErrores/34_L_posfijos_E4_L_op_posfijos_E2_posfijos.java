///[SinErrores]
// Posfijos sobre variables, elementos y atributos encadenados, como sentencia y como valor

class A1 {
    int x;
    A1 otro;

    void m1(int p, int[] v, A1[] w) {
        p++;
        p--;
        x++;
        v[0]++;
        otro.x--;
        w[0].otro.x++;
        var y = p++ + v[1]--;
        y = x++ + 10;
        v[x++] = y--;
    }
}

class Init{
    static void main()
    { }
}
