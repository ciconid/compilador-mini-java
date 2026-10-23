///[Error:x|6]
// Una declaracion de variable local no puede ser el cuerpo directo de un while

class A1 {
    void m1() {
        while (false) var x = 1;
    }
}

class Init{
    static void main()
    { }
}
