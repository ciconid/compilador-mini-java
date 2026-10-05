///[Error:m|9]
// Implementacion de interfaz generica instanciada con signatura incorrecta

interface I1<T>{
    void m(T x);
}

class A1 implements I1<String>{
    void m(int x)
    {}
}

class Init{
    static void main()
    { }
}
