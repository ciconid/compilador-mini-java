class ArregloInicializadorAnidadoAtributoArgumentoReturn {
    int[][] a = new int[][] {{1}};

    int[][] metodo() {
        f(new int[][] {{1}});
        return new int[][] {{2}};
    }
}