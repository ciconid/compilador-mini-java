///[SinErrores]
// Bloques hermanos pueden declarar el mismo nombre porque sus ambitos no se superponen

class A1 {
    void m1(boolean p1) {
        {
            var x = 1;
            x = x + 1;
        }
        {
            var x = true;
            x = !x;
        }
        if (p1) {
            var y = 'a';
        } else {
            var y = "b";
        }
        while (p1) {
            var y = 2;
            p1 = y > 1;
        }
        var x = 'z';
        var y = x;
    }
}

class Init{
    static void main()
    { }
}
