///[Error:x|9]
// Una declaracion de variable local no puede ser el cuerpo directo de un else

class A1 {
    void m1() {
        if (true) {
            var x = 1;
        } else
            var x = 2;
    }
}

class Init{
    static void main()
    { }
}
