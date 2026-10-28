///[Error:T|9]
// A1 no es generica, asi que T no esta declarado como argumento del new

class Caja<T> {
}

class A1 {
    void m1() {
        var c = new Caja<T>();
    }
}

class Init{
    static void main()
    { }
}
