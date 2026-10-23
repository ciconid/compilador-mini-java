///[Error:++|7]
// Una expresion parentizada no es asignable

class A1 {
    void m1(int x) {
        x++;
        (x)++;
    }
}

class Init{
    static void main()
    { }
}
