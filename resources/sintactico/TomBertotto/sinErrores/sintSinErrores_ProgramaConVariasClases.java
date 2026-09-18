///[SinErrores]
interface Figura {
    int area();
    void dibujar();
}

class Cuadrado implements Figura {
    int lado;

    public Cuadrado(int unLado) {
        lado = unLado;
    }

    int area() {
        return lado * lado;
    }

    void dibujar() {
        Consola.imprimir(area());
    }
}

class Principal {
    static void main() {
        var figuras = new Figura[2];
        figuras[0] = new Cuadrado(3);
        var i = 0;
        while (i < 2) {
            if (figuras[i] != null) figuras[i].dibujar();
            i = i + 1;
        }
    }
}
