///[Error:A1|11]
// A1 declara un constructor con un parametro, asi que no se agrega el constructor por defecto

class A1 {
    A1(int x) {
    }
}

class B2 {
    void m1() {
        new A1();
    }
}

class Init{
    static void main()
    { }
}
