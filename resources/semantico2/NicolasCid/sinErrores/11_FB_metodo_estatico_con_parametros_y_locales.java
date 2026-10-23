///[SinErrores]
// En un metodo estatico se pueden usar parametros y locales, aunque haya atributos con otros nombres

class A1 {
    int a1;

    static int m1(int p1) {
        var x = p1 + 1;
        p1 = x * 2;
        return p1;
    }
}

class Init{
    static void main()
    { }
}
