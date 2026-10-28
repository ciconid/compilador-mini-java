///[SinErrores]
// Atributos inicializados con diamantes, arreglos de T, ternarios, posfijos e inicializadores de arreglos

class Caja<T> {
    T[] datos = new T[3];
    Caja<T> otra = new Caja<>();
}

class A1 {
    int a = 1;
    int b = a++;
    boolean c = b > 0;
    int d = c ? a : b;
    Caja<String> caja = new Caja<>();
    int[] v = new int[]{a, b, d};
    int[][] m = new int[][]{v, {1, 2}};
    Caja<String>[] cajas = new Caja<String>[]{caja, new Caja<>()};
}

class Init{
    static void main()
    { }
}
