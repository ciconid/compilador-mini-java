///[Error:new|6]
// Basura despues del inicializador: los dos "new" no estan conectados por ningun operador

class ArregloBasuraDespuesDelInicializador {
    void metodo() {
        var a = new int[] {1} new int[] {2};
    }
}