///[Error:}|6]
// Coma final en el inicializador: tras el "," se espera otro elemento, no el cierre "}"

class ArregloComaFinal {
    void metodo() {
        var a = new int[] {1, 2,};
    }
}