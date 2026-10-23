///[SinErrores]
// Creacion de arreglos con tipos base primitivos, clases, interfaces, genericos instanciados y parametros de tipo

interface I1 {
}

class A1 {
}

class Caja<T> {
    T dato;

    void m1() {
        var a = new int[3];
        var m = new char[2][a.length];
        var c = new A1[4];
        var g = new Caja<String>[2];
        var gt = new Caja<T>[3][4];
        var t = new T[10];
        var i = new I1[5];
        var b = new boolean[1][2][a[0] + 1];
        a = new int[a[0]];
        m[0] = new char[5];
        c[0] = new A1();
        g[1] = new Caja<String>();
        gt[0][1] = this;
        t[0] = dato;
        b[0][1][2] = true;
        var o = new Object();
        o = a;
        o = new int[2][2];
    }
}

class Init{
    static void main()
    { }
}
