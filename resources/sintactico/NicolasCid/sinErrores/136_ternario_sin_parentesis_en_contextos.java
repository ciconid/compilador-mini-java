class TernarioSinParentesisEnContextos {
    int metodo() {
        var m = a > b ? a : b;
        f(a ? b : c);
        if (a ? b : c) {
        }
        return a ? b : c;
    }
}