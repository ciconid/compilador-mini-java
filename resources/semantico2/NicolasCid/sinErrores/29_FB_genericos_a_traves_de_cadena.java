///[SinErrores]
// Los miembros genericos se ven desde el tipo del receptor, tambien a traves de la herencia

class Caja<T> {
    T dato;

    T obtener() {
        return dato;
    }

    void poner(T p) {
        dato = p;
    }

    Caja<T> copia() {
        return this;
    }
}

class CajaS extends Caja<String> {
}

class A1 {
    void m1(Caja<String> c, CajaS cs, Caja<A1> ca) {
        var s = c.dato;
        s = c.obtener();
        c.poner("hola");
        s = c.copia().obtener();
        s = cs.dato;
        s = cs.obtener();
        cs.poner(s);
        c = cs.copia();
        ca.obtener().m1(c, cs, ca);
        ca.dato.m1(cs, cs, ca);
    }
}

class Init{
    static void main()
    { }
}
