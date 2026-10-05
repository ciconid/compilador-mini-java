class A1<T> extends Caja<T> implements I1<T>, I2<Lista<String>> {
}

interface I3<T> extends I1<T>, I2<String> {
}