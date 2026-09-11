///[Error:else|6]
// <Else> con "else" inmediato: tras el "else", <Sentencia> no admite otro "else" como primer token

class Aa {
    void metodo() {
        if (true) ; else else ;
    }
}