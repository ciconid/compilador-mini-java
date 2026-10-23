///[Error:Caja|9]
// El tipo base de un arreglo no puede omitir el argumento de una clase generica

class Caja<T> {
}

class A1 {
    void m1() {
        var v = new Caja[3];
    }
}

class Init{
    static void main()
    { }
}
