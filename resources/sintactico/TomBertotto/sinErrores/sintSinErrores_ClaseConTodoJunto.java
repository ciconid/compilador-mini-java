///[SinErrores]
class Clase<T> extends Base<T> {
    T valor;
    int[][] matriz;
    Lista<Otra> lista;

    public Clase(T unValor, int[] datos) {
        valor = unValor;
        matriz = new int[2][3];
        lista = new Lista<Otra>();
    }

    static T crear(Lista<T> origen, int n) {
        var i = 0;
        while (i < n) {
            if (origen.get(i) != null) return origen.get(i);
            else i = i + 1;
        }
        return null;
    }

    void procesar() {
        matriz[0][1] = Otra.calcular(valor, -1) + (2 * 3) % 4;
        this.lista.agregar(new Otra("hola", 'x', true));
    }
}
