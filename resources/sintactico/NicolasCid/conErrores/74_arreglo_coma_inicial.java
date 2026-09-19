///[Error:,|6]
// Coma inicial en el inicializador: la lista de elementos no puede comenzar con ","

class ArregloComaInicial {
    void metodo() {
        var a = new int[] {, 1, 2};
    }
}