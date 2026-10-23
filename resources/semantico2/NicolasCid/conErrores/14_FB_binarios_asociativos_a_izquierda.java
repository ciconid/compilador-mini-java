///[Error:+|8]
// Los binarios no tienen precedencia y asocian a izquierda: 1 == 1 + 2 es (1 == 1) + 2,
// y + no admite un operando boolean

class A1 {
    boolean m1() {
        return
            1 == 1 + 2;
    }
}

class Init{
    static void main()
    { }
}
