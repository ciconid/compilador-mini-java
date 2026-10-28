///[Error:=|11]
// Visto desde Caja<String>, datos es String[] y sus componentes son String

class Caja<T> {
    T[] datos;
}

class A1 {
    void m1(Caja<String> c) {
        c.datos[0] = "hola";
        c.datos[0] = 3;
    }
}

class Init{
    static void main()
    { }
}
