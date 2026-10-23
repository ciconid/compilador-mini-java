///[SinErrores]
// Operadores aritmeticos, relacionales, logicos y unarios con operandos de los tipos correctos

class A1 {
    int aritmeticos() {
        return -4 + 10 * 3 - +2 / 1 % 5;
    }

    boolean relacionales() {
        return 1 < 2;
    }

    boolean logicos() {
        return !true && (false || true);
    }

    boolean asociatividadIzquierda() {
        return 1 + 2 > 3 && true || false;
    }

    boolean parentesis() {
        return ((4 + 10 + 33) > 12) || ((99 * 15) == 23) && (97 <= 12) || !true && ((4 / 2) != 2);
    }
}

class Init{
    static void main()
    { }
}
