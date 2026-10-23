///[Error:x|6]
// El inicializador se chequea antes de que la variable sea visible

class A1 {
    void m1() {
        var x = x + 1;
    }
}

class Init{
    static void main()
    { }
}
