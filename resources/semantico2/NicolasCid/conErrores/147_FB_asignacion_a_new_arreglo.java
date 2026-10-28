///[Error:=|6]
// Crear un arreglo no designa un destino asignable

class A1 {
    void m1(int[] v) {
        new int[3] = v;
    }
}

class Init{
    static void main()
    { }
}
