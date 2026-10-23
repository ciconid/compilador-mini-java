///[SinErrores]
// El T propio de Derivada y el T conservado de Base conviven sin mezclarse

class Base<T> {
    T dato;

    T obtener() {
        return dato;
    }
}

class Derivada<T> extends Base {
    T propio;

    void m1(T p) {
        propio = p;
        var h = obtener();
        h = dato;
        dato = h;
    }

    T m2() {
        return propio;
    }
}

class Init{
    static void main()
    { }
}
