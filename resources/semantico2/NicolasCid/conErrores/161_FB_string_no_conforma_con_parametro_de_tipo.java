///[Error:=|8]
// String no conforma con un parametro de tipo T no instanciado

class Caja<T> {
    T contenido;

    void m1() {
        contenido = "hola";
    }
}

class Init{
    static void main()
    { }
}
