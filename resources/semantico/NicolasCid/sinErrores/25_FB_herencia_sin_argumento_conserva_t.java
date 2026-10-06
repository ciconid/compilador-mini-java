///[SinErrores]
// Herencia sin argumento conserva T y la redefinicion usa T

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
