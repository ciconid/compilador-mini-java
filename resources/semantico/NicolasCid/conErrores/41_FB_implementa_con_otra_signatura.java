///[Error:m|9]
// Clase que implementa un metodo de la interfaz con otra signatura

interface I1{
    void m(int a);
}

class A1 implements I1{
    void m(char a)
    {}
}

class Init{
    static void main()
    { }
}
