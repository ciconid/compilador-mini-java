///[Error:toString|8]
// Un parametro de tipo no instanciado no permite seleccionar miembros con punto

class Caja<T> {
    T dato;

    void m1() {
        dato.toString();
    }
}

class Init{
    static void main()
    { }
}
