///[Error:Caja|9]
// MiniJava no tiene tipos raw: crear una clase generica sin argumento es error

class Caja<T> {
}

class A1 {
    void m1() {
        var c = new Caja();
    }
}

class Init{
    static void main()
    { }
}
