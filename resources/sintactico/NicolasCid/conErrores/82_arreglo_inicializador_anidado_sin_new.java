///[Error:{|6]
// Inicializador anidado sin "new": cada fila debe construirse con "new int[] {...}"

class ArregloInicializadorAnidadoSinNew {
    void metodo() {
        var a = new int[][] {{1, 2}, {3}};
    }
}