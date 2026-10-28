///[Error:=|13]
// Como en Java, un diamante usado como receptor no tiene tipo esperado: se infiere Caja<Object>,
// y copia() devuelve Caja<Object>, que no conforma con Caja<String>

class Caja<T> {
    Caja<T> copia() {
        return this;
    }
}

class A1 {
    void m1(Caja<String> c) {
        c = new Caja<>().copia();
    }
}

class Init{
    static void main()
    { }
}
