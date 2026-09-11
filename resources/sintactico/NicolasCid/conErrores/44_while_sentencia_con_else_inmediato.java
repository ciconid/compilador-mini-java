///[Error:else|6]
// <While> con "else" inmediato: tras el ")" de la condicion, <Sentencia> no admite "else" como primer token

class Aa {
    void metodo() {
        while (true) else ;
    }
}