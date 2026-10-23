///[Error:x|6]
// Una declaracion de variable local no puede ser el cuerpo directo de un if

class A1 {
    void m1() {
        if (true) var x = 1;
    }
}

class Init{
    static void main()
    { }
}
