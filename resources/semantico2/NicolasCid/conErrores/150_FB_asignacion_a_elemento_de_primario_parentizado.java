///[Error:=|7]
// Un primario parentizado no puede ser la base de un destino de asignacion, tampoco al indexarlo

class A1 {
    void m1(int[] v) {
        v[0] = 1;
        (v)[0] = 1;
    }
}

class Init{
    static void main()
    { }
}
