///[Error:;|12]
// Un acceso a atributo encadenado no es una sentencia valida

class A1 {
    int x;

    A1 crearA() {
        return new A1();
    }

    void m1() {
        crearA().x;
    }
}

class Init{
    static void main()
    { }
}
