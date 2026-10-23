///[Error:=|12]
// Dos clases sin relacion de herencia no conforman entre si

class A1 {
}

class B2 {
}

class C3 {
    void m1(A1 a, B2 b) {
        a = b;
    }
}

class Init{
    static void main()
    { }
}
