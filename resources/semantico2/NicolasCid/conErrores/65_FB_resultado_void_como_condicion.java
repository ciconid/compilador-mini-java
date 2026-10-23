///[Error:if|6]
// Una llamada a un metodo void no puede ser la condicion de un if

class A1 {
    void m1() {
        if (m2()) ;
    }

    void m2() {
    }
}

class Init{
    static void main()
    { }
}
