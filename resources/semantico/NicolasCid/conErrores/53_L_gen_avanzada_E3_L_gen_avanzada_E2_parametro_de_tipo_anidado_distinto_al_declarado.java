///[Error:U|8]
// Uso de U anidado en una clase que declara T

class Lista<T>{
}

class Caja<T>{
    Lista<Caja<U>> x;
}

class Init{
    static void main()
    { }
}
