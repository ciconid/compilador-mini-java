///[Error:poner|14]
// I2 extiende I1<String>, asi que poner espera un String

interface I1<T> {
    void poner(T x);
}

interface I2 extends I1<String> {
}

class A1 {
    void m1(I2 i) {
        i.poner("hola");
        i.poner(3);
    }
}

class Init{
    static void main()
    { }
}
