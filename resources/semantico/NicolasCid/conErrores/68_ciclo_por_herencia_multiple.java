///[Error:I1|4]
// Ciclo de extension entre interfaces a traves de una lista

interface I1 extends I2, I3{
}

interface I2{
}

interface I3 extends I1{
}

class Init{
    static void main()
    { }
}
