///[Error:=|9]
// A1 no es ancestro de Caja, asi que el diamante se infiere como Caja<Object>, que no conforma con A1

class Caja<T> {
}

class A1 {
    void m1(A1 a) {
        a = new Caja<>();
    }
}

class Init{
    static void main()
    { }
}
