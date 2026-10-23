///[Error:=|14]
// El T conservado de Base no es el T propio de Derivada, aunque se llamen igual

class Base<T> {
    T obtener() {
        return null;
    }
}

class Derivada<T> extends Base {
    T dato;

    void m1() {
        dato = obtener();
    }
}

class Init{
    static void main()
    { }
}
