package com.mojain.aircalc.operators;

import com.mojain.aircalc.Operator;
import com.mojain.aircalc.Real;

public class Plus implements Operator {

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public Real evaluate(Real... operands) {
        if (operands.length != arity()) {
            throw new IllegalArgumentException(String.format("Plus operator takes exactly %d operands", arity()));
        }
        return operands[1].add(operands[0]);
    }

    public String toString() {
        return "+";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Plus;
    }
}
