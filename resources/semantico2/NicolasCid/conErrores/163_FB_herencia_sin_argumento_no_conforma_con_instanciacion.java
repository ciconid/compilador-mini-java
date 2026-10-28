///[Error:=|12]
// Derivada conserva el T de Base, asi que no conforma con Base<String>

class Base<T> {
}

class Derivada extends Base {
}

class Uso {
    void m1(Base<String> b) {
        b = new Derivada();
    }
}

class Init{
    static void main()
    { }
}
