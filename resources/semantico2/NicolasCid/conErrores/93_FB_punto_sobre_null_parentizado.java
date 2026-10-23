///[Error:x|6]
// null no permite acceder a miembros con punto

class A1 {
    void m1() {
        var y = (null).x;
    }
}

class Init{
    static void main()
    { }
}
