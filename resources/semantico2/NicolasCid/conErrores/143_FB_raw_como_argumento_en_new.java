///[Error:Caja|9]
// El argumento de un new tampoco puede ser una clase generica sin argumento

class Caja<T> {
}

class A1 {
    void m1() {
        var c = new Caja<Caja>();
    }
}

class Init{
    static void main()
    { }
}
