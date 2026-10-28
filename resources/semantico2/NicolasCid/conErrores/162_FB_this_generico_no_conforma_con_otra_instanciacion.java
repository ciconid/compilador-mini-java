///[Error:=|8]
// Dentro de Caja<T>, this tiene tipo Caja<T>, que no conforma con Caja<Object>

class Caja<T> {
    Caja<Object> otra;

    void m1() {
        otra = this;
    }
}

class Init{
    static void main()
    { }
}
