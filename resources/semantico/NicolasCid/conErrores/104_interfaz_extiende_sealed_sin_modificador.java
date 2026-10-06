///[Error:J2|7]
// Una interfaz que extiende una interfaz sealed debe ser sealed o non-sealed

sealed interface I1 permits J2{
}

interface J2 extends I1{
}

class Init{
    static void main()
    { }
}
