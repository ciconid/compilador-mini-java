///[Error:T|7]
// Un cuerpo estatico no puede crear un arreglo de Caja<T>

class Caja<T> {
    static void m1() {
        var ok = new Caja<String>[2];
        var c = new Caja<T>[2];
    }
}

class Init{
    static void main()
    { }
}
