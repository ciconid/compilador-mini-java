///[Error:x|6]
// Una local solo es visible despues de su declaracion

class A1 {
    void m1() {
        x = 1;
        var x = 2;
    }
}

class Init{
    static void main()
    { }
}
