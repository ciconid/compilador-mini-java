///[SinErrores]
// La asignacion produce un valor del tipo del destino y puede usarse en contextos de expresion

class A1 {
    int a1;

    int m1(int x, int y) {
        var z = (x = 3);
        x = (y = 4);
        a1 = (x = y) + z;
        if ((x = 5) > 2) {
            return x = 6;
        }
        return z;
    }
}

class Init{
    static void main()
    { }
}
