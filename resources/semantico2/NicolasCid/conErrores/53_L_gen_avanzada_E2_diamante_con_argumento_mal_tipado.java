///[Error:Caja|11]
// El diamante se infiere como Caja<String> por la asignacion, y 3 no conforma con String

class Caja<T> {
    Caja(T x) {
    }
}

class A1 {
    void m1(Caja<String> s) {
        s = new Caja<>(3);
    }
}

class Init{
    static void main()
    { }
}
