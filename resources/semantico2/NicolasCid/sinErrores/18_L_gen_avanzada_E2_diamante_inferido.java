///[SinErrores]
// El diamante infiere el argumento del tipo esperado (asignacion, return, a traves de una interfaz)
// y sin contexto se infiere Object

interface Contenedor<T> {
}

class Lista<E> implements Contenedor<E> {
}

class Caja<T> {
    Caja() {
    }

    Caja(T x) {
    }
}

class Uso {
    Caja<String> c;

    void m1(Contenedor<String> contenedor, Caja<Object> objetos) {
        c = new Caja<>();
        c = new Caja<>("x");
        contenedor = new Lista<>();
        var sinContexto = new Caja<>();
        objetos = sinContexto;
    }

    Caja<String> m2() {
        return new Caja<>("y");
    }
}

class Init{
    static void main()
    { }
}
