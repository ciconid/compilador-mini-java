package org.example.analizadorsintactico;

import java.util.Arrays;
import java.util.List;

public class Primeros {

    public static List<String> obtener(String noTerminal) {
        switch (noTerminal) {
            case "clase":
                return Arrays.asList("prClass");
            case "interfaz":
                return Arrays.asList("prInterface");
            case "miembro":
                return Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen", "prStatic", "prVoid", "prPublic");
            case "metodoInterfaz":
                return Arrays.asList("prBoolean", "prChar", "prInt", "idClase", "idGen", "prVoid");
            //            case "":
//                return Arrays.asList("");
            //            case "":
//                return Arrays.asList("");
            //            case "":
//                return Arrays.asList("");
            //            case "":
//                return Arrays.asList("");
            //            case "":
//                return Arrays.asList("");
            //            case "":
//                return Arrays.asList("");
//            case "":
//                return Arrays.asList("");


            default:
                throw new RuntimeException("No existen primeros definidos para: " + noTerminal);


        }
    }
}
