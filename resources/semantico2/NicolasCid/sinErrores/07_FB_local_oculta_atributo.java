///[SinErrores]
// Una local puede ocultar a un atributo; su inicializador todavia ve al atributo

class A1 {
    int a1;

    void m1() {
        var a1 = a1 + 1 == 2;
        a1 = false;
    }
}

class Init{
    static void main()
    { }
}
