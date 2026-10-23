///[Error:return|7]
// La local toma el tipo de su inicializador (char), que no conforma con int

class A1 {
    int m1() {
        var x = 'a';
        return x;
    }
}

class Init{
    static void main()
    { }
}
