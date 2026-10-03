package org.example.analizadorsemantico;

public class ErrorSemantico extends RuntimeException {
    public ErrorSemantico(String message) {
        super(message);
    }
}
