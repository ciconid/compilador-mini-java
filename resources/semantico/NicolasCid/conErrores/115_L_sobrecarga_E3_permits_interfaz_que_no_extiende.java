///[Error:J2|4]
// Los tipos de permits de una interfaz deben implementarla o extenderla

sealed interface I1 permits J2{
}

interface J2{
}

class Init{
    static void main()
    { }
}
