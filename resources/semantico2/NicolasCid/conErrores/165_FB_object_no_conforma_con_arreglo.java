///[Error:=|7]
// Un arreglo conforma con Object, pero Object no conforma con un arreglo

class A1 {
    void m1(int[] v, Object o) {
        o = v;
        v = o;
    }
}

class Init{
    static void main()
    { }
}
