package com.mojain.aircalc;

import com.mojain.aircalc.commands.*;
import com.mojain.aircalc.operators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Parser {

    List<Command> parse(String input) {
        List<Command> commands = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input);
        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            index++;

            if (token.equalsIgnoreCase("quit")) {
                commands.add(new Quit());
                continue;
            }

            if (token.equalsIgnoreCase("clear")) {
                commands.add(new Clear());
                continue;
            }

            Real number = tryToParseNumber(token);
            if (number != null) {
                commands.add(new Push(number));
                continue;
            }

            Operator operator = tryToParseOperator(token, index);
            if (operator != null) {
                commands.add(new Eval(operator));
                continue;
            }

            System.err.format("Could not parse token: %s\n", token);
        }
        return commands;
    }

    private Real tryToParseNumber(String token) {
        try {
            return new Real(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Operator tryToParseOperator(String token, int index) {
        if (token.equalsIgnoreCase("sqrt")) return new SquareRoot(index);
        if (token.equalsIgnoreCase("+")) return new Plus(index);
        if (token.equalsIgnoreCase("-")) return new Minus(index);
        if (token.equalsIgnoreCase("*")) return new Times(index);
        if (token.equalsIgnoreCase("/")) return new Divides(index);
        return null;
    }
}
