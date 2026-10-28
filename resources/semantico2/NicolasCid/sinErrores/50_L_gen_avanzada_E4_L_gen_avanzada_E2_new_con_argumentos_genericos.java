///[SinErrores]
// Los argumentos de un constructor generico se chequean con la sustitucion, y un diamante como argumento
// toma el tipo del formal

class A1 {
}

class B1 extends A1 {
}

class Caja<T> {
    T dato;

    public Caja(T d) {
        dato = d;
    }
}

class Uso {
    void m1() {
        var c = new Caja<A1>(new B1());
        var a = c.dato;
        a = new B1();
        var cc = new Caja<Caja<String>>(new Caja<>("hola"));
        var s = cc.dato.dato;
    }
}

class Init{
    static void main()
    { }
}
