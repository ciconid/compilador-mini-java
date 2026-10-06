///[Error:I1|4]
// Ciclo de extension entre interfaces

interface I1 extends I2{
}

interface I2 extends I1{
}

class Init{
    static void main()
    { }
}
