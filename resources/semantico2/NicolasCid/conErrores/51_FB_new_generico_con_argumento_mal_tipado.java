///[Error:Caja|11]
// En new Caja<String>(...) el parametro formal T se chequea como String

class Caja<T> {
    Caja(T x) {
    }
}

class A1 {
    void m1() {
        new Caja<String>(3);
    }
}

class Init{
    static void main()
    { }
}
