///[Error:a1|8]
// El acceso implicito a un atributo en un estatico es error tambien dentro de una subexpresion

class A1 {
    int a1;

    static int m1() {
        return (a1 + 1);
    }
}

class Init{
    static void main()
    { }
}
