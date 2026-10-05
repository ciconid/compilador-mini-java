class A1 extends Caja<Lista<String>> {
}

class B2 implements I1<Lista<Nodo>> {
}

interface I2 extends I1<Caja<Lista<String>>> {
}