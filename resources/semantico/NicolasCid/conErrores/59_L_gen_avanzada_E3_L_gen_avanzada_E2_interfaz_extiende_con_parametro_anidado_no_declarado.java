///[Error:T|10]
// Interfaz no generica que extiende usando T anidado

interface I1<T>{
}

class Caja<T>{
}

interface I2 extends I1<Caja<T>>{
}

class Init{
    static void main()
    { }
}
