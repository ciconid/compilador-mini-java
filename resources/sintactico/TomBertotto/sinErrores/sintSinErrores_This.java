///[SinErrores]
class Clase {
    void metodo() {
        a = this;
        this.valor = 1;
        this.metodo();
        this.a.b().c = 2;
    }
}
