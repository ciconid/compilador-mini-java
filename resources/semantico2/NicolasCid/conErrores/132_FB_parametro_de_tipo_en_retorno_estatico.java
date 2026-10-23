///[Error:T|5]
// Un metodo estatico no puede usar el parametro de tipo de la clase en su encabezado

class Caja<T> {
    static T identidad() {
        return null;
    }
}

class Init{
    static void main()
    { }
}
