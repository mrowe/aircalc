package com.mojain.aircalc.commands;

import com.mojain.aircalc.operators.Plus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvalTest {

    @Test
    public void equals() {
        Eval a = new Eval(new Plus());
        Eval b = new Eval(new Plus());
        assertEquals(a, b);
    }
}