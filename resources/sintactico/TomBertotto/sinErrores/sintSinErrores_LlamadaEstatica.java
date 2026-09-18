///[SinErrores]
class Clase {
    void metodo() {
        Otra.metodo();
        Otra.metodo(1, 2);
        Otra.metodo().valor = 1;
        Otra.metodo()[0].otro();
    }
}
