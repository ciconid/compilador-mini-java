///[Error:==|12]
// Una interfaz y una clase que no la implementa no conforman en ninguna direccion

interface I1 {
}

class A1 {
}

class B2 {
    boolean m1(I1 i, A1 a) {
        return i == a;
    }
}

class Init{
    static void main()
    { }
}
