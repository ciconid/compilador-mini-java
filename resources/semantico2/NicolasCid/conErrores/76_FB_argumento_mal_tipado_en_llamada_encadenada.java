///[Error:m2|10]
// El argumento boolean no conforma con el parametro int de m2

class B1 {
    void m2(int p) {}
}

class A1 {
    void m1(B1 b) {
        b.m2(true);
    }
}

class Init{
    static void main()
    { }
}
