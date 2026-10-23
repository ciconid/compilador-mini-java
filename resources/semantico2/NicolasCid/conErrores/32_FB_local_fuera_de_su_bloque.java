///[Error:x|9]
// Una variable local deja de ser visible al terminar su bloque

class A1 {
    int m1() {
        {
            var x = 1;
        }
        return x;
    }
}

class Init{
    static void main()
    { }
}
