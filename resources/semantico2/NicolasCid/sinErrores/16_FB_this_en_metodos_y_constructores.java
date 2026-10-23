///[SinErrores]
// this es valido en constructores y metodos de instancia; su tipo es la clase actual con su parametro

class A1 {
    A1 otro;

    A1() {
        otro = this;
    }

    boolean m1() {
        return (this == otro) || (this != null);
    }

    A1 m2() {
        return this;
    }
}

class Caja<T> {
    Caja<T> siguiente;

    void m1() {
        siguiente = this;
    }
}

class Init{
    static void main()
    { }
}
