///[SinErrores]
// String y System heredan el estatico debugPrint de Object, que puede llamarse con receptor o con el nombre de la clase

class A1 {
    void m1(String s) {
        "a".debugPrint(1);
        s.debugPrint(2);
        System.debugPrint(3);
        String.debugPrint(4);
        System.printIln(System.read());
        var t = "x".toString().toString();
        System.printSln(t);
    }
}

class Init{
    static void main()
    { }
}
