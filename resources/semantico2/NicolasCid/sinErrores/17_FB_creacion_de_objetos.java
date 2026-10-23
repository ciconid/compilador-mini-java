///[SinErrores]
// Creacion de objetos con y sin argumentos, constructor por defecto, genericos y new como sentencia

class A1 {
    A1() {
    }

    A1(int x, String s) {
    }
}

class B2 extends A1 {
}

class Caja<T> {
    T dato;

    Caja(T d) {
        dato = d;
    }

    Caja<T> copia() {
        return new Caja<T>(dato);
    }
}

class Uso {
    void m1(A1 a, B2 b, Caja<String> c, Object o) {
        a = new A1();
        a = new A1(3, "x");
        a = new B2();
        b = new B2();
        c = new Caja<String>("hola");
        c = new Caja<String>(null);
        o = new Caja<Uso>(new Uso());
        new A1();
        new A1(1, null);
    }

    A1 m2() {
        return new B2();
    }
}

class Init{
    static void main()
    { }
}
