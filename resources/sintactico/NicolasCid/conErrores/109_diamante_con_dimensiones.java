///[Error:[|6]
// La notacion diamante solo se admite al instanciar con argumentos actuales

class Clase {
    void m() {
        a = new Caja<>[5];
    }
}