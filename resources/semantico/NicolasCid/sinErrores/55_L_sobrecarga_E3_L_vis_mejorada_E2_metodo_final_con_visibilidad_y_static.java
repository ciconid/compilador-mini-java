///[SinErrores]
// final se combina con la visibilidad y static en el orden visibilidad, static, final

class A1<T>{
    public static final void m()
    {}

    private final int n()
    {}

    static final A1 o()
    {}

    public final T p()
    {}
}

class Init{
    static void main()
    { }
}
