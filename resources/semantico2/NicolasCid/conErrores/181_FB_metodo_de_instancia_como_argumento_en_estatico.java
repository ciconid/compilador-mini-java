///[Error:m2|10]
// La llamada implicita a un metodo de instancia en un estatico es error tambien como argumento

class A1 {
    int m2() {
        return 1;
    }

    static void m1() {
        System.printIln(m2());
    }
}

class Init{
    static void main()
    { }
}
