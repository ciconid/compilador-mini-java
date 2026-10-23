///[SinErrores]
// Las ramas de un ternario reciben el tipo esperado, asi que un diamante puede inferirse en una rama

class Caja<T> {
}

class A1 {
    void m1(boolean b, Caja<String> c) {
        c = b ? new Caja<>() : c;
        c = b ? null : new Caja<>();
    }
}

class Init{
    static void main()
    { }
}
