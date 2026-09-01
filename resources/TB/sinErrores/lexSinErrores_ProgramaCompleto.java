class Lista extends Base implements Coleccion {
    static int total;
    int[] datos;
    boolean vacia;
    char separador;

    public void agregar(int valor) {
        if (total >= 10 && !vacia) {
            datos[total] = valor;
            total++;
        } else {
            this.reiniciar();
        }
    }

    static int suma(int[] xs) {
        int i;
        int acum;
        i = 0;
        acum = 0;
        while (i < 10) {
            acum = acum + xs[i] % 3;
            i++;
        }
        return acum;
    }

    public void reiniciar() {
        var nueva = new Lista();
        vacia = true;
        separador = ',';
        total = 0;
    }
}

//#class,1
//#Lista,1
//#extends,1
//#Base,1
//#implements,1
//#Coleccion,1
//#{,1
//#static,2
//#int,2
//#total,2
//#;,2
//#int,3
//#[,3
//#],3
//#datos,3
//#;,3
//#boolean,4
//#vacia,4
//#;,4
//#char,5
//#separador,5
//#;,5
//#public,7
//#void,7
//#agregar,7
//#(,7
//#int,7
//#valor,7
//#),7
//#{,7
//#if,8
//#(,8
//#total,8
//#>=,8
//#10,8
//#&&,8
//#!,8
//#vacia,8
//#),8
//#{,8
//#datos,9
//#[,9
//#total,9
//#],9
//#=,9
//#valor,9
//#;,9
//#total,10
//#++,10
//#;,10
//#},11
//#else,11
//#{,11
//#this,12
//#.,12
//#reiniciar,12
//#(,12
//#),12
//#;,12
//#},13
//#},14
//#static,16
//#int,16
//#suma,16
//#(,16
//#int,16
//#[,16
//#],16
//#xs,16
//#),16
//#{,16
//#int,17
//#i,17
//#;,17
//#int,18
//#acum,18
//#;,18
//#i,19
//#=,19
//#0,19
//#;,19
//#acum,20
//#=,20
//#0,20
//#;,20
//#while,21
//#(,21
//#i,21
//#<,21
//#10,21
//#),21
//#{,21
//#acum,22
//#=,22
//#acum,22
//#+,22
//#xs,22
//#[,22
//#i,22
//#],22
//#%,22
//#3,22
//#;,22
//#i,23
//#++,23
//#;,23
//#},24
//#return,25
//#acum,25
//#;,25
//#},26
//#public,28
//#void,28
//#reiniciar,28
//#(,28
//#),28
//#{,28
//#var,29
//#nueva,29
//#=,29
//#new,29
//#Lista,29
//#(,29
//#),29
//#;,29
//#vacia,30
//#=,30
//#true,30
//#;,30
//#separador,31
//#=,31
//#',',31
//#;,31
//#total,32
//#=,32
//#0,32
//#;,32
//#},33
//#},34
//#$,176
