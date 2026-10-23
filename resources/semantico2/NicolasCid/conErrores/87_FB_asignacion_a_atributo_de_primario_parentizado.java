///[Error:=|9]
// Un primario parentizado no puede ser la base de un destino de asignacion

class A1 {
    int x;

    void m1(A1 a) {
        a.x = 1;
        (a).x = 1;
    }
}

class Init{
    static void main()
    { }
}
