///[Error:return|8]
// Un parametro de tipo no instanciado no tiene cota implicita Object

class Caja<T> {
    T contenido;

    Object comoObjeto() {
        return contenido;
    }
}

class Init{
    static void main()
    { }
}
