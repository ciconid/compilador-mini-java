///[Error:x|9]
// Las interfaces no declaran atributos

interface I1 {
}

class A1 {
    void m1(I1 i) {
        var n = i.x;
    }
}

class Init{
    static void main()
    { }
}
