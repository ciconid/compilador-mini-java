///[SinErrores]
// Un metodo estatico de una clase generica puede usar instanciaciones concretas, pero no T

class A1 {
}

class Caja<T> {
    T dato;

    static Caja<String> crear(Caja<A1> c) {
        var arr = new Caja<String>[10];
        var otra = new Caja<A1>();
        otra = c;
        arr[0] = new Caja<String>();
        return arr[0];
    }

    static void m1() {
        var c = Caja.crear(new Caja<A1>());
        var s = c.dato;
    }
}

class Init{
    static void main()
    { }
}
