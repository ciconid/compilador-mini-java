///[Error:Lista|10]
// La herencia permite omitir el argumento de la clase heredada, pero no el de su argumento

class Caja<T> {
}

class Lista<T> {
}

class Otra extends Caja<Lista> {
}

class Init{
    static void main()
    { }
}
