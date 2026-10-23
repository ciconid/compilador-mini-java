///[Error:length|6]
// Con tipo estatico Object no se puede acceder a length

class A1 {
    void m1(Object o) {
        var n = o.length;
    }
}

class Init{
    static void main()
    { }
}
