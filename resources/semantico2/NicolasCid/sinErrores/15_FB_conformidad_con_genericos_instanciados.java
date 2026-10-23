///[SinErrores]
// La conformidad recorre la herencia aplicando las sustituciones de cada relacion

class Base<T> {
}

class Intermedia<U> extends Base<U> {
}

class Final extends Intermedia<String> {
}

interface Contenedor<T> {
}

class Lista<E> implements Contenedor<E> {
}

class Uso {
    void m1(Final f, Intermedia<String> i, Base<String> b, Object o) {
        i = f;
        b = f;
        b = i;
        o = b;
    }

    void m2(Lista<Uso> l, Contenedor<Uso> c) {
        c = l;
    }
}

class Caja<T> {
    T contenido;

    T obtener() {
        return contenido;
    }

    void guardar(T nuevo) {
        contenido = nuevo;
        contenido = null;
    }
}

class Init{
    static void main()
    { }
}
