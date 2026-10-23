///[SinErrores]
// En Intermedia los miembros de Base tienen tipo U; en Final, tipo String

class Base<T> {
    T dato;

    T obtener() {
        return dato;
    }
}

class Intermedia<U> extends Base<U> {
    U otro() {
        var u = dato;
        u = obtener();
        return u;
    }
}

class Final extends Intermedia<String> {
    void m1() {
        var s = "a";
        s = dato;
        s = obtener();
        s = otro();
    }
}

class Uso {
    void m1(Final f, Intermedia<Final> i) {
        var s = f.obtener();
        s = f.dato;
        var g = i.otro();
        g = i.dato;
        g.m1();
    }
}

class Init{
    static void main()
    { }
}
