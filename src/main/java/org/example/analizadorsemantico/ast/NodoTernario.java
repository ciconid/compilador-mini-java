package org.example.analizadorsemantico.ast;

import org.example.analizadorlexico.Token;
import org.example.analizadorsemantico.*;

public class NodoTernario extends NodoExpresion {
    private final Token tokenInterrogacion;
    private final NodoExpresion condicion;
    private final NodoExpresion siVerdadero;
    private final NodoExpresion siFalso;

    public NodoTernario(Token tokenInterrogacion, NodoExpresion condicion, NodoExpresion siVerdadero,
                        NodoExpresion siFalso) {
        this.tokenInterrogacion = tokenInterrogacion;
        this.condicion = condicion;
        this.siVerdadero = siVerdadero;
        this.siFalso = siFalso;
    }

    public Tipo chequear() {
        return chequear(null);
    }

    public Tipo chequear(Tipo esperado) {
        Tipo tipoCondicion = condicion.chequear();
        if (!tipoCondicion.conformaCon(new TipoBoolean())) {
            throw new ErrorSemantico(tokenInterrogacion, "La condicion del ternario tiene que ser boolean, pero es "
                    + tipoCondicion);
        }
        Tipo tipoVerdadero = siVerdadero.chequear(esperado);
        Tipo tipoFalso = siFalso.chequear(esperado);
        if (tipoVerdadero instanceof TipoVoid || tipoFalso instanceof TipoVoid) {
            throw new ErrorSemantico(tokenInterrogacion, "Las ramas del ternario tienen que producir un valor");
        }
        if (tipoFalso.conformaCon(tipoVerdadero)) {
            return tipoVerdadero;
        }
        if (tipoVerdadero.conformaCon(tipoFalso)) {
            return tipoFalso;
        }
        if (tipoVerdadero instanceof TipoReferencia referenciaVerdadera
                && tipoFalso instanceof TipoReferencia referenciaFalsa) {
            return referenciaVerdadera.supertipoComun(referenciaFalsa);
        }
        if (esReferencia(tipoVerdadero) && esReferencia(tipoFalso)) {
            return TipoReferencia.object(tokenInterrogacion.nroDeLinea());
        }
        throw new ErrorSemantico(tokenInterrogacion, "Las ramas del ternario son de tipos incompatibles: "
                + tipoVerdadero + " y " + tipoFalso);
    }

    private boolean esReferencia(Tipo tipo) {
        return tipo instanceof TipoReferencia || tipo instanceof TipoArreglo || tipo instanceof TipoParametro;
    }
}
