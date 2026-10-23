///[Error:b|5]
// Como en Java, un inicializador no puede usar por nombre simple un atributo declarado mas abajo

class A1 {
    int a = b;
    int b = 1;
}

class Init{
    static void main()
    { }
}
