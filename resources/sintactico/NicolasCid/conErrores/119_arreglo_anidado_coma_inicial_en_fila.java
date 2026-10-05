///[Error:,|6]
// Coma inicial dentro de una fila del inicializador anidado

class ArregloAnidadoComaInicialEnFila {
    void metodo() {
        var m = new int[][] {{, 1}};
    }
}