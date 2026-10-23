///[SinErrores]
// Inicializadores de arreglos con elementos conformes en cada nivel

class A1 {
}

class B1 extends A1 {
}

class C1 {
    void m1() {
        var v = new int[]{1, 2, 3};
        var m = new int[][]{{1}, {2, 3}, v, {}};
        var c = new A1[]{new B1(), null, new A1()};
        var s = new String[]{"a", "b"};
        var e = new int[]{};
        var p = new char[][][]{{{'a'}}, {}};
        v = new int[]{v[0], m[1][1], v.length};
    }
}

class Init{
    static void main()
    { }
}
