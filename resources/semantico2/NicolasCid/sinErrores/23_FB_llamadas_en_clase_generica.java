///[SinErrores]
// Dentro de una clase generica, los parametros y retornos T se chequean como T

class Caja<T> {
    T dato;

    T obtener() {
        return dato;
    }

    void guardar(T x) {
        dato = x;
    }

    void copiar(Caja<T> otra) {
        guardar(obtener());
        var d = obtener();
        guardar(d);
        guardar(null);
        reemplazar(new Caja<>());
    }

    void reemplazar(Caja<T> otra) {
    }
}

class Init{
    static void main()
    { }
}
