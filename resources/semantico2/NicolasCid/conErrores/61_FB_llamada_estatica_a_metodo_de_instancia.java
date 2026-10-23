///[Error:m2|11]
// Un metodo de instancia no puede invocarse usando solo el nombre de la clase

class A1 {
    void m2() {
    }
}

class B2 {
    void m1() {
        A1.m2();
    }
}

class Init{
    static void main()
    { }
}
