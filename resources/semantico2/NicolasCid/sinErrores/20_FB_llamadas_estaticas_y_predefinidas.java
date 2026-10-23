///[SinErrores]
// Metodos estaticos llamados desde estaticos y de instancia, con y sin nombre de clase,
// y metodos predefinidos de Object y System

class A1 {
    static int doble(int x) {
        return x * 2;
    }

    static void m1() {
        var y = doble(3);
        A1.doble(y);
        System.printIln(A1.doble(1));
        Object.debugPrint(y);
        debugPrint(2);
        System.printSln("hola");
        System.println();
        var c = System.read();
        System.printBln(c > 0);
        System.printC('c');
    }

    void m2() {
        doble(1);
        var s = toString();
        System.printS(s);
    }
}

class Init{
    static void main()
    { }
}
