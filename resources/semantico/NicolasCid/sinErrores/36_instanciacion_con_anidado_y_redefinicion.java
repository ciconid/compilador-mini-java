///[SinErrores]
// Redefinicion correcta luego de instanciar T con Lista<String>

class Caja<T>{
    T m(T x)
    {}
}

class Lista<T>{
}

class A1 extends Caja<Lista<String>>{
    Lista<String> m(Lista<String> x)
    {}
}

class Init{
    static void main()
    { }
}
