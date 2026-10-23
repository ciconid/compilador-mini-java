///[Error:return|6]
// Un return con expresion de resultado void es incorrecto, incluso en un metodo void

class A1 {
    void m1() {
        return m2();
    }

    void m2() {
    }
}

class Init{
    static void main()
    { }
}
