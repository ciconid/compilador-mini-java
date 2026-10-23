///[Error:x|8]
// Una variable local no puede ocultar a una local todavia visible de un bloque contenedor

class A1 {
    void m1() {
        var x = 1;
        {
            var x = true;
        }
    }
}

class Init{
    static void main()
    { }
}
