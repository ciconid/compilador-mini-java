///[SinErrores]
// MiniJava no exige retorno en todos los caminos ni rechaza codigo inalcanzable

class A1 {
    int sinRetorno() {
    }

    int parcial() {
        if (true) return 1;
    }

    int conCodigoInalcanzable() {
        return 1;
        return 2;
    }
}

class Init{
    static void main()
    { }
}
