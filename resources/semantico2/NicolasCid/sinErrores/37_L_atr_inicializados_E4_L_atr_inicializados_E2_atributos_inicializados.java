///[SinErrores]
// Inicializadores con literales, atributos anteriores, this, llamadas, arreglos y atributos heredados

class A1 {
    int a = 3;
    int b = a + 1;
    String s = "hola";
    A1 otro = null;
    int c = m1();
    A1 yo = this;
    int d = yo.a;
    int[] v = new int[b];
    int e = this.f;
    int f = 2;
    Object o = v;
    int g = A1.crear().a;

    int m1() {
        return a;
    }

    static A1 crear() {
        return new A1();
    }
}

class B2 extends A1 {
    int h = a + c;
    A1 padre = this;
}

class Caja<T> {
    T dato = null;
    Caja<T> yo = this;
    T otro = dato;
}

class CajaS extends Caja<String> {
    String s = dato;
    Caja<String> c = this;
}

class Init{
    static void main()
    { }
}
