///[SinErrores]
// Arreglos cuyo tipo base es un generico anidado

class Lista<T>{
}

class Caja<T>{
    Caja<Lista<T>>[][] y;
}

class A1{
    Caja<Lista<String>>[] x;
}

class Init{
    static void main()
    { }
}
