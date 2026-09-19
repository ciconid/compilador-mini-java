///[Error:new|6]
// Falta coma entre filas multidimensionales: tras cerrar una fila se espera "," o el cierre, se encontro "new"

class ArregloFaltaComaEntreFilasMultidimensionales {
    void metodo() {
        var a = new int[][] {new int[] {1} new int[] {2}};
    }
}