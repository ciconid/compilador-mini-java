///[Error:x|12]
// Atributo con el mismo nombre que uno heredado del abuelo

class A1{
    int x;
}

class B2 extends A1{
}

class C3 extends B2{
    int x;
}

class Init{
    static void main()
    { }
}
