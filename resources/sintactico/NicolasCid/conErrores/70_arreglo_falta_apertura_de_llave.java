///[Error:1|6]
// Falta "{" de apertura del inicializador: tras el "[]" vacio se exige la llave "{", se encontro "1"

class ArregloFaltaAperturaDeLlave {
    void metodo() {
        var a = new int[] 1, 2};
    }
}