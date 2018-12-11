package com.mojain.aircalc;

import com.mojain.aircalc.commands.*;
import com.mojain.aircalc.operators.Plus;
import com.mojain.aircalc.operators.SquareRoot;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void shouldHandleEmptyInput() {
        assertTrue(parser.parse("").isEmpty());
    }

    @Test
    public void shouldParseQuitCommand() {
        assertEquals(Collections.singletonList(new Quit()), parser.parse("quit"));
    }

    @Test
    public void shouldParseClearCommand() {
        assertEquals(Collections.singletonList(new Clear()), parser.parse("clear"));
    }

    @Test
    public void shouldParseSingleNumber() {
        assertEquals(Collections.singletonList(new Push(new Real(1))), parser.parse("1"));
    }

    @Test
    public void shouldParseSingleDecimal() {
        assertEquals(Collections.singletonList(new Push(new Real(1.4142135624))), parser.parse("1.4142135624"));
    }

    @Test
    public void shouldParseSingleOperator() {
        assertEquals(Collections.singletonList(new Eval(new Plus())), parser.parse("+"));
    }

    @Test
    public void shouldParseSingleSqrtOperator() {
        assertEquals(Collections.singletonList(new Eval(new SquareRoot())), parser.parse("sqrt"));
    }

    @Test
    public void shouldParseASequenceOfOperandsAndOperators() {
        List result = parser.parse("1 2 + clear");
        assertEquals(4, result.size());
        assertEquals(new Push(new Real(1)), result.get(0));
        assertEquals(new Push(new Real(2)), result.get(1));
        assertEquals(new Eval(new Plus()), result.get(2));
        assertEquals(new Clear(), result.get(3));
    }

    @Test
    public void shouldIgnoreBadNumbersAndOperators() {
        List result = parser.parse("clear 1 z2 3 % quit");
        assertEquals(4, result.size());
        assertEquals(new Clear(), result.get(0));
        assertEquals(new Push(new Real(1)), result.get(1));
        assertEquals(new Push(new Real(3)), result.get(2));
        assertEquals(new Quit(), result.get(3));
    }
}