///[Error:T|5]
// La prohibicion incluye a T dentro de argumentos genericos y arreglos

class Caja<T> {
    static void m1(Caja<T>[] v) {}
}

class Init{
    static void main()
    { }
}
