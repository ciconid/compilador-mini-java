///[Error:x|6]
// Un primitivo no permite acceder a miembros con punto

class A1 {
    void m1(int p) {
        p.x = 1;
    }
}

class Init{
    static void main()
    { }
}
