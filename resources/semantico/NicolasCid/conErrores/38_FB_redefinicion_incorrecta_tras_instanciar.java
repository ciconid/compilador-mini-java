///[Error:m|10]
// Redefinicion incorrecta luego de instanciar T con String

class Caja<T>{
    T m()
    {}
}

class A1 extends Caja<String>{
    int m()
    {}
}

class Init{
    static void main()
    { }
}
