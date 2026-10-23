///[Error:=|5]
// m2 devuelve boolean, que no conforma con int

class A1 {
    int x = m2();

    boolean m2() {
        return true;
    }
}

class Init{
    static void main()
    { }
}
