package com.mojain.aircalc;

public class InsufficientOperandsException extends RuntimeException {
    public InsufficientOperandsException(String message) {
        super(message);
    }
}
