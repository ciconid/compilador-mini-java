///[Error:=|6]
// Los arreglos son invariantes: String[] no conforma con Object[]

class A1 {
    void m1(String[] s, Object[] o) {
        o = s;
    }
}

class Init{
    static void main()
    { }
}
