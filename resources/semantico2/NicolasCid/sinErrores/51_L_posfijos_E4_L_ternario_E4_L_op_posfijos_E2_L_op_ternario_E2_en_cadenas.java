///[SinErrores]
// Ternarios y posfijos dentro de encadenados, indices y argumentos, y encadenados sobre creaciones de arreglos

class A1 {
    int x;
    int[] v;

    int[] getArr() {
        return v;
    }

    A1 yo() {
        return this;
    }

    int id(int p) {
        return p;
    }

    void m1(boolean b, A1 a, A1 c, int[] w, int i) {
        var n = (b ? a : c).id(1);
        n = (b ? a : c).x;
        n = (b ? v : w)[0];
        v[i++]++;
        n = id(i++);
        getArr()[0] = 3;
        yo().x++;
        n = new int[5].length;
        n = (new int[3])[0];
        n = (b ? a : c).getArr()[i--];
    }
}

class Init{
    static void main()
    { }
}
