package com.mojain.aircalc.operators;

import com.mojain.aircalc.Operator;
import com.mojain.aircalc.Real;

public class SquareRoot implements Operator {

    @Override
    public int arity() {
        return 1;
    }

    @Override
    public Real evaluate(Real... operands) {
        if (operands.length != arity()) {
            throw new IllegalArgumentException(String.format("SquareRoot operator takes exactly %d operands", arity()));
        }
        return new Real(Math.sqrt(operands[0].asDouble()));
    }

    public String toString() {
        return "√";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SquareRoot;
    }
}
