///[SinErrores]
// Cada elemento de un inicializador de arreglo recibe el tipo base como tipo esperado, asi que puede ser un diamante

class Caja<T> {
}

class A1 {
    void recibir(Caja<String> c) {
    }

    void m1() {
        var arr = new Caja<String>[]{new Caja<>(), null};
        var m = new Caja<A1>[][]{{new Caja<>()}, {}};
        arr[0] = new Caja<>();
        recibir(arr[1]);
    }
}

class Init{
    static void main()
    { }
}
