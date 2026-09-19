///[Error:{|6]
// Faltan los corchetes: tras "new int" se espera "[", se encontro "{"

class ArregloNewSinCorchetes {
    void metodo() {
        var a = new int {1, 2};
    }
}