///[Error:return|10]
// Se chequean todas las ramas de un if, incluida la del else

class A1 {
    int m1() {
        if (true) {
            return 1;
        } else {
            while (false)
                return 'c';
        }
    }
}

class Init{
    static void main()
    { }
}
