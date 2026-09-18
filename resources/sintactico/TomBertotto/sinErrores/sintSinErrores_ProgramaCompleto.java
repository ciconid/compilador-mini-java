///[SinErrores]
class Punto {
    int x;
    int y;

    public Punto(int unX, int unY) {
        this.x = unX;
        this.y = unY;
    }

    int getX() {
        return x;
    }

    void mover(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }

    static Punto origen() {
        return new Punto(0, 0);
    }
}
