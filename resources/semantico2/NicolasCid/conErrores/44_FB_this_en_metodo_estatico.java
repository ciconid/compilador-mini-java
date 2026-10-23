///[Error:this|6]
// this no es valido en un metodo estatico

class A1 {
    static void m1() {
        var x = this;
    }
}

class Init{
    static void main()
    { }
}
