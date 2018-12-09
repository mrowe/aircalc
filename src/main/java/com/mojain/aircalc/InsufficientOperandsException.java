package com.mojain.aircalc;

public class InsufficientOperandsException extends Exception {
    public InsufficientOperandsException(String message) {
        super(message);
    }
}
