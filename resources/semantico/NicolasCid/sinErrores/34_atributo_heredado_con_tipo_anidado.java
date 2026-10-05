///[SinErrores]
// Atributo de tipo anidado heredado de una clase generica instanciada

class Lista<T>{
}

class Caja<T>{
    Lista<T> x;
}

class A1 extends Caja<String>{
}

class Init{
    static void main()
    { }
}
