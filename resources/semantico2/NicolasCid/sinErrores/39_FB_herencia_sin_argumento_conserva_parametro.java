///[SinErrores]
// Al heredar sin argumento, los miembros heredados conservan el T de Base

class Base<T> {
    T dato;

    T obtener() {
        return dato;
    }

    void poner(T p) {
        dato = p;
    }
}

class Derivada extends Base {
    void m1() {
        var x = obtener();
        dato = x;
        poner(obtener());
    }
}

class Uso {
    void m1(Derivada d) {
        var y = d.obtener();
        d.poner(y);
        d.dato = d.obtener();
    }
}

class Init{
    static void main()
    { }
}
