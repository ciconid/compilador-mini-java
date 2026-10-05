class TernarioCondicionLlamadaAccesoLiteralUnario {
    void metodo() {
        x = obj.m() ? a : b;
        x = f(1) ? a : b;
        x = true ? 1 : 0;
        x = !a ? -b : +c;
    }
}