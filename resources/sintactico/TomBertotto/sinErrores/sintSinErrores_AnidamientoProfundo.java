///[SinErrores]
class Clase {
    void metodo() {
        {
            if (a) {
                while (b) {
                    if (c) {
                        while (d) {
                            {
                                if (e) metodo();
                                else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
