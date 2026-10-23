///[SinErrores]
// == y != entre operandos que conforman en alguna direccion

class A1 {
    boolean chars() {
        return 'a' == 'b';
    }

    boolean booleans() {
        return true != false;
    }

    boolean ints() {
        return 1 == 2;
    }

    boolean strings() {
        return "hola" == "chau";
    }

    boolean nullYString() {
        return null != "hola";
    }

    boolean stringYNull() {
        return "hola" == null;
    }
}

class Init{
    static void main()
    { }
}
