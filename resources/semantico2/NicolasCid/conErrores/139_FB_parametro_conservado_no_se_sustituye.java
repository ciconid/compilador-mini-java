///[Error:=|14]
// En C1, x conserva el T de A1: el argumento String de B1<String> solo sustituye el T de B1

class A1<T> {
    T x;
}

class B1<T> extends A1 {
}

class C1 extends B1<String> {
    void m1() {
        var s = "a";
        s = x;
    }
}

class Init{
    static void main()
    { }
}
