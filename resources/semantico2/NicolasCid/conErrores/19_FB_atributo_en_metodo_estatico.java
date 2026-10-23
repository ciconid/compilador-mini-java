///[Error:a1|8]
// En un metodo estatico no se puede acceder implicitamente a un atributo

class A1 {
    int a1;

    static int m1() {
        return a1;
    }
}

class Init{
    static void main()
    { }
}
