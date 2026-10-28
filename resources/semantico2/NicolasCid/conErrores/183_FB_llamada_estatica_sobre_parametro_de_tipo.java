///[Error:T|8]
// En Clase.m(...), Clase tiene que nombrar una clase existente, y T es un parametro de tipo

class Caja<T> {
    T dato;

    void m1() {
        var s = T.toString();
    }
}

class Init{
    static void main()
    { }
}
