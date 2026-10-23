///[Error:=|9]
// Visto desde CajaS, dato es String y no conforma con int

class Caja<T> {
    T dato;
}

class CajaS extends Caja<String> {
    int n = dato;
}

class Init{
    static void main()
    { }
}
