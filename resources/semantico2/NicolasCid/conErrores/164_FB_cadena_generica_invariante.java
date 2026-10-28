///[Error:=|15]
// Final conforma con Base<String> a traves de Intermedia<String>, pero no con Base<Object>

class Base<T> {
}

class Intermedia<U> extends Base<U> {
}

class Final extends Intermedia<String> {
}

class Uso {
    void m1(Final f, Base<Object> b) {
        b = f;
    }
}

class Init{
    static void main()
    { }
}
