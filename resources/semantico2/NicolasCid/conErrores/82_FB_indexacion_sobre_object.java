///[Error:[|6]
// Con tipo estatico Object no se puede indexar

class A1 {
    void m1(Object o) {
        var e = o[0];
    }
}

class Init{
    static void main()
    { }
}
