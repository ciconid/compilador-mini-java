///[Error:x|8]
// Una local no puede repetir el nombre de un parametro del constructor, tampoco en un bloque anidado

class A1 {
    public A1(int x) {
        {
            var y = 1;
            var x = 2;
        }
    }
}

class Init{
    static void main()
    { }
}
