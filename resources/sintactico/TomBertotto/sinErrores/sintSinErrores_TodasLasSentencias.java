///[SinErrores]
class Clase {
    int metodo() {
        ;
        var a = 1;
        a = 2;
        metodo();
        {
            ;
        }
        if (a) metodo();
        else ;
        while (a) ;
        return a;
    }
}
