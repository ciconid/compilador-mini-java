///[Error:>|6]
// La notacion diamante no se admite dentro de un argumento generico

class Clase {
    void m() {
        a = new Caja<Lista<>>();
    }
}