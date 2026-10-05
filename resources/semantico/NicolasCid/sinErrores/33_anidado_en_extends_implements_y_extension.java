///[SinErrores]
// Argumentos anidados en extends, implements y extension de interfaces

class Caja<T>{
}

class Lista<T>{
}

class Nodo{
}

interface I1<T>{
}

class A1 extends Caja<Lista<String>>{
}

class B2 implements I1<Caja<Nodo>>{
}

interface I2 extends I1<Lista<String>>{
}

class Init{
    static void main()
    { }
}
