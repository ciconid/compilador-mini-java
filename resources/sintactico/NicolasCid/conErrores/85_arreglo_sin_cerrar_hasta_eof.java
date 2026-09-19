///[Error:$|7]
// Inicializador sin cerrar hasta EOF: tras "new int[] {" nunca llega la llave de cierre, se detecta el fin de archivo

class ArregloSinCerrarHastaEOF {
    void metodo() {
        var a = new int[] {1, 2
