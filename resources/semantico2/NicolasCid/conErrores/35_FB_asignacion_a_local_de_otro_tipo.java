///[Error:=|7]
// La local b es boolean por su inicializador, no se le puede asignar un int

class A1 {
    void m1() {
        var b = true;
        b = 1;
    }
}

class Init{
    static void main()
    { }
}
