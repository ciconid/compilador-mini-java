///[Error:{|6]
// Falta "]" de la dimension: tras "new int[" se espera una expresion y luego "]", se encontro "{"

class ArregloFaltaCorcheteDeCierre {
    void metodo() {
        var a = new int[ {1, 2};
    }
}