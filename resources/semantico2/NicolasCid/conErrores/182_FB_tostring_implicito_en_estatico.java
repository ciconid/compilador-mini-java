///[Error:toString|6]
// toString es un metodo de instancia heredado de Object, asi que no puede llamarse sin receptor en un estatico

class A1 {
    static String m1() {
        return toString();
    }
}

class Init{
    static void main()
    { }
}
