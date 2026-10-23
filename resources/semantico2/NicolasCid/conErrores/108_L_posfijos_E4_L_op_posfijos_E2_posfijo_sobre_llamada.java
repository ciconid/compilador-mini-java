///[Error:--|10]
// El operando de un posfijo tiene que ser asignable

class A1 {
    int m2() {
        return 1;
    }

    void m1() {
        var y = m2()--;
    }
}

class Init{
    static void main()
    { }
}
