///[Error:return|6]
// Que new produzca un objeto no significa que el constructor pueda retornarlo

class A1 {
    public A1() {
        return this;
    }
}

class Init{
    static void main()
    { }
}
