///[Error:T|11]
// Uso de T anidado en una clase que no es generica

class Caja<T>{
}

class Lista<T>{
}

class A1{
    Caja<Lista<T>> x;
}

class Init{
    static void main()
    { }
}
