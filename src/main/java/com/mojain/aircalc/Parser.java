package com.mojain.aircalc;

import com.mojain.aircalc.commands.*;
import com.mojain.aircalc.operators.*;

import java.util.*;

class Parser {

    private static final Map<String, Command> VALID_TOKENS = new HashMap<String, Command>() {{
        put("undo", new Undo());
        put("quit", new Quit());
        put("clear", new Clear());
    }};

    private static final Map<String, Operator> VALID_OPERATORS = new HashMap<String, Operator>() {{
        put("sqrt", new SquareRoot());
        put("+", new Plus());
        put("-", new Minus());
        put("*", new Times());
        put("/", new Divides());
    }};

    List<Command> parse(String input) {
        List<Command> commands = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (VALID_TOKENS.containsKey(token)) {
                commands.add(VALID_TOKENS.get(token));
                continue;
            }

            if (VALID_OPERATORS.containsKey(token)) {
                commands.add(new Eval(VALID_OPERATORS.get(token)));
                continue;
            }

            Real number = tryToParseNumber(token);
            if (number != null) {
                commands.add(new Push(number));
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
}
