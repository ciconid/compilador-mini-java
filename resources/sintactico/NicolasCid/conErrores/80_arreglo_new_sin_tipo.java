///[Error:[|6]
// Falta el tipo en "new": tras "new" se espera un tipo (primitivo, idClase o idGen), se encontro "["

class ArregloNewSinTipo {
    void metodo() {
        var a = new [] {1, 2};
    }
}