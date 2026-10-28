///[SinErrores]
// this.x selecciona el atributo oculto por un parametro, una asignacion boolean puede ser condicion,
// una local puede llamarse como un metodo y una clase puede usarse antes de declararse

class A1 {
    int x;

    void m1(int x, boolean b) {
        this.x = x;
        this.x = this.x + 1;
        while (b = false) {
        }
        if (b = true) {
        }
        var m1 = 3;
        m1 = m1 + x;
        m1(m1, b);
        var otra = new B2();
        otra.y = m1;
    }
}

class B2 {
    int y;
}

class Init{
    static void main()
    { }
}
