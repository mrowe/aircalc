package com.mojain.aircalc.operators;

import com.mojain.aircalc.Operator;
import com.mojain.aircalc.Real;

public class Divides implements Operator {

    private final int tokenNumber;

    public Divides(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public int tokenNumber() {
        return tokenNumber;
    }

    @Override
    public Real evaluate(Real... operands) {
        if (operands.length != arity()) {
            throw new IllegalArgumentException(String.format("Divides operator takes exactly %d operands", arity()));
        }
        return operands[1].divide(operands[0]);
    }

    public String toString() { return "/"; }

    @Override
    public boolean equals(Object o) {
        return o instanceof Divides;
    }
}
