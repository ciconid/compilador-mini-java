///[SinErrores]
// Uso de variables locales, parametros y atributos en expresiones y asignaciones

class A1 {
    int a1;
    boolean a2;

    int m1(int p1, boolean p2) {
        var x = p1 * 2;
        var c = 'c';
        var s = "hola";
        a1 = x + p1 - a1;
        a2 = p2 && !a2 || (x < a1);
        c = 'd';
        s = "chau";
        p1 = a1;
        if (a2 && (s != null) && (c == 'd')) {
            return x;
        }
        return p1;
    }

    A1() {
        a1 = 0;
        a2 = false;
    }
}

class Init{
    static void main()
    { }
}
