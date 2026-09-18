///[SinErrores]
class Clase {
    void metodo() {
        a[b = 1] = 2;
        a[b + c] = 3;
        a[metodo()] = 4;
    }
}
