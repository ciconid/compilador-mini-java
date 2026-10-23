///[Error:x|7]
// Dos variables locales con el mismo nombre en el mismo bloque

class A1 {
    void m1() {
        var x = 1;
        var x = 2;
    }
}

class Init{
    static void main()
    { }
}
