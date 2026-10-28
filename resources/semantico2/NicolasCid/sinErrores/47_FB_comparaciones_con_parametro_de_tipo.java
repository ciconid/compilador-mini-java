///[SinErrores]
// Un T puede compararse con otro T y con null, y null conforma con T

class Caja<T> {
    T dato;

    boolean m1(T otro) {
        return (dato == null) && (dato != otro) || (null == otro);
    }

    T m2() {
        return null;
    }
}

class Init{
    static void main()
    { }
}
