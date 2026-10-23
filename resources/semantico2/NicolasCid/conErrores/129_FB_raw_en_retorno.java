///[Error:Caja|8]
// Un tipo de retorno no puede usar una clase generica sin argumento

class Caja<T> {
}

class A1 {
    Caja m1() {
        return null;
    }
}

class Init{
    static void main()
    { }
}
