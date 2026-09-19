///[Error:{|6]
// Tamanio e inicializador juntos: tras "new int[3]" el "{" no puede continuar la sentencia

class ArregloTamanioEInicializadorJuntos {
    void metodo() {
        var a = new int[3] {1, 2, 3};
    }
}