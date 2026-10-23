///[Error:=|11]
// El tipo de new B2() es B2, que no conforma con A1

class A1 {
}

class B2 {
    A1 a1;

    void m1() {
        a1 = new B2();
    }
}

class Init{
    static void main()
    { }
}
