///[Error:T|6]
// Un cuerpo estatico no puede usar T como argumento de un new

class Caja<T> {
    static void m1() {
        var c = new Caja<T>();
    }
}

class Init{
    static void main()
    { }
}
