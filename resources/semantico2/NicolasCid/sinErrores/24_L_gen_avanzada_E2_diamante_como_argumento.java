///[SinErrores]
// Un diamante usado como argumento toma el tipo del parametro formal como tipo esperado

class Caja<T> {
}

class Uso {
    void recibir(Caja<String> c) {
    }

    void m1() {
        recibir(new Caja<>());
    }
}

class Init{
    static void main()
    { }
}
