///[Error:==|8]
// T no conforma con Object ni Object con T, asi que no pueden compararse

class Caja<T> {
    T dato;

    boolean m1(Object o) {
        return dato == o;
    }
}

class Init{
    static void main()
    { }
}
