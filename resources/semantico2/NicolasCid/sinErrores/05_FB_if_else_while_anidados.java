///[SinErrores]
// if, else y while anidados, con y sin bloques, y sentencias vacias

class A1 {
    int m1() {
        ;
        while (1 < 2) {
            if (true)
                ;
            else if (false) {
                {
                    return 1;
                }
            } else
                while (!false)
                    return 2;
        }
        {
            ;
        }
        return 3;
    }
}

class Init{
    static void main()
    { }
}
