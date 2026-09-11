///[Error:(|6]
// New de un arreglo de objetos seguido de una llamada; la gramatica no permite combinar ambas formas en un mismo RestoNew

class Foo {
    void metodo() {
        var a = new Persona[5]();
    }
}
