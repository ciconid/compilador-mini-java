///[Error:this|8]
// Los parentesis no hacen valido un this en contexto estatico

class A1 {
    int x;

    static void m1() {
        var n = (this).x;
    }
}

class Init{
    static void main()
    { }
}
