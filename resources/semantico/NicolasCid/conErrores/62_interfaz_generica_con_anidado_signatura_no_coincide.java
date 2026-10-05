///[Error:m|15]
// Implementacion de interfaz instanciada con un anidado y signatura incorrecta

interface I1<T>{
    void m(T x);
}

class Lista<T>{
}

class Nodo{
}

class A1 implements I1<Lista<String>>{
    void m(Lista<Nodo> x)
    {}
}

class Init{
    static void main()
    { }
}
