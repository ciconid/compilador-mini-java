///[Error:m|10]
// Al heredar sin argumento, m conserva el T de Caja: el T propio de A1 es otro tipo y la redefinicion es incorrecta

class Caja<T>{
    T m()
    {}
}

class A1<T> extends Caja{
    T m()
    {}
}

class Init{
    static void main()
    { }
}
