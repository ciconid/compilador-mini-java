///[Error:m|10]
// Herencia sin argumento conserva T, redefinir con String es incorrecto

class Caja<T>{
    T m()
    {}
}

class A1 extends Caja{
    String m()
    {}
}

class Init{
    static void main()
    { }
}
