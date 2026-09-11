///[Error:else|6]
// <If> con "else" inmediato: tras el ")" de la condicion, <Sentencia> no admite "else" como primer token

class Aa {
    void metodo() {
        if (true) else ;
    }
}