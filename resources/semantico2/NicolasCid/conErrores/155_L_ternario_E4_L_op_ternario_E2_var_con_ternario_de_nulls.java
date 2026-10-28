///[Error:x|6]
// Un ternario con dos ramas null tiene el tipo de null, que no permite inferir el tipo de la local

class A1 {
    void m1(boolean b) {
        var x = b ? null : null;
    }
}

class Init{
    static void main()
    { }
}
