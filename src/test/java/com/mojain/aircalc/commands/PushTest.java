package com.mojain.aircalc.commands;

import com.mojain.aircalc.Real;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PushTest {

    @Test
    public void equals() {
        Push a = new Push(new Real(1));
        Push b = new Push(new Real(1));
        assertEquals(a, b);
    }
}