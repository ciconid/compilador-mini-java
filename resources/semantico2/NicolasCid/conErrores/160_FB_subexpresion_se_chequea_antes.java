///[Error:+|6]
// Las subexpresiones se chequean antes que el operador que las contiene

class A1 {
    boolean m1() {
        return (1 + 'a') && 3;
    }
}

class Init{
    static void main()
    { }
}
