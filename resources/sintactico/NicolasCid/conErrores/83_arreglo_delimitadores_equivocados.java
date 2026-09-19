///[Error:(|6]
// Delimitadores equivocados: tras "new int[]" el inicializador exige "{", se encontro "("

class ArregloDelimitadoresEquivocados {
    void metodo() {
        var a = new int[] (1, 2);
    }
}