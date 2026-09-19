///[Error:;|6]
// Falta "}" de cierre del inicializador: tras "1, 2" se espera "," o "}", se encontro ";"

class ArregloFaltaCierreDeLlave {
    void metodo() {
        var a = new int[] {1, 2;
    }
}