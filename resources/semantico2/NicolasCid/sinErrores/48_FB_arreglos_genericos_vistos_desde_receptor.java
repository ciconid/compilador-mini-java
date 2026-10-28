///[SinErrores]
// Los arreglos de T se ven desde el receptor con la sustitucion: en Caja<String>, T[] es String[]

class Caja<T> {
    T[] datos;

    T[] todos() {
        return datos;
    }

    T primero() {
        return datos[0];
    }
}

class A1 {
    void m1(Caja<String> c, Caja<A1>[] cajas) {
        var s = c.datos[0];
        s = c.todos()[1];
        s = c.primero();
        c.datos[0] = s;
        c.datos = new String[3];
        var arr = c.todos();
        arr[0] = "hola";
        cajas[0].datos[0].m1(c, cajas);
        cajas[1].primero().m1(c, cajas);
    }
}

class Init{
    static void main()
    { }
}
