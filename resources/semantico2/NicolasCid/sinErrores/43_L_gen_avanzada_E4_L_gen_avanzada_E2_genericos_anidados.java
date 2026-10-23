///[SinErrores]
// Genericos anidados en expresiones y sentencias, con sustitucion en cada nivel y diamante

class Caja<T> {
    T dato;

    T obtener() {
        return dato;
    }

    void poner(T p) {
        dato = p;
    }
}

class A1 {
    Caja<Caja<String>> cc;

    void m1(Caja<Caja<Caja<A1>>> ccc) {
        var s = cc.dato.dato;
        s = cc.obtener().obtener();
        cc.poner(new Caja<String>());
        cc.dato.poner("hola");
        var a = ccc.obtener().dato.obtener();
        a.m1(ccc);
        cc = new Caja<Caja<String>>();
        var arr = new Caja<Caja<String>>[3];
        arr[0] = cc;
        cc.poner(new Caja<>());
        cc = new Caja<>();
        ccc.dato.dato = new Caja<>();
    }
}

class Init{
    static void main()
    { }
}
