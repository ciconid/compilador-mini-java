///[Error:T|6]
// Un cuerpo estatico no puede crear un arreglo de T

class Caja<T> {
    static void m1() {
        var datos = new T[10];
    }
}

class Init{
    static void main()
    { }
}
