package com.mojain.aircalc;

public class InsufficientOperandsException extends RuntimeException {
    public final int tokenNumber;

    public InsufficientOperandsException(int tokenNumber, String message) {
        super(message);
        this.tokenNumber = tokenNumber;
    }
}
