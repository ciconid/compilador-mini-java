///[Error:A1|11]
// El argumento del constructor (boolean) no conforma con el parametro formal (int)

class A1 {
    A1(int x) {
    }
}

class B2 {
    void m1() {
        new A1(true);
    }
}

class Init{
    static void main()
    { }
}
