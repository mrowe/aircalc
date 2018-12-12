[![Build Status](https://travis-ci.com/mrowe/aircalc.svg?token=PNMMiyYqy5UxLSwsJdLy&branch=master)](https://travis-ci.com/mrowe/aircalc)

# AirCalc - a simple RPN calculator

The calculator has a stack that can contain real numbers.

 * The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.
 * Numbers are pushed on to the stack. Operators operate on numbers that are on the stack. 
 * Available operators are +, -, *, /, sqrt, undo, clear.
 * Operators pop their parameters off the stack, and push their results back onto the stack.
 * The ‘clear’ operator removes all items from the stack.
 * The ‘undo’ operator undoes the previous operation. “undo undo” will undo the previo us two operations. • sqrt performs a square root on the top item from the stack.
 * The ‘+’, ‘-’, ‘*’, ‘/’ operators perform addition, subtraction, multiplication and division respectively on the top two items from the stack.
 * After processing an input string, the calculator displays the current contents of the stack as a space-separated list.
 * Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or less if it causes no loss of precision).
 * All numbers should be formatted as plain decimal strings (ie. no engineering formatting).
 * If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed:
     operator <operator> (position: <pos>): insufficient parameters
 * After displaying the warning, all further processing of the string terminates and the current state of the stack is displayed
 
 ## Prerequisites
 
  * Java 9.0.1
  * Gradle 4.10
 
 ## Building
 
 To build the app and run its tests:
 
 ```bash
 $ ./gradlew clean check
```

To package the application in a JAR:

```bash
 $ ./gradlew jar
```

To run the application from the packaged JAR:

```bash
 $ java -jar build/libs/aircalc-1.0-SNAPSHOT.jar
```

## Acceptance tests

To run the suite of acceptance tests:

```
./acceptance_tests.rb
```


# Notes

A couple of comments on the implementation vs requirements/expectations:

 * the "insufficient parameters" error reports the position as "token number", not strict character position number

 * in the examples the square root of 2 is rendered as "1.4142135623". the actual value to 15 decimal places is 1.414213562373095, which should round to 10 places as 1.4142135624
