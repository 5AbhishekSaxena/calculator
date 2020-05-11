package com.example.android.calci.utility;

import android.util.Log;

import java.util.Stack;

/**
 * @author Abhishek Saxena
 * @since 19/8/19 1:38 AM
 */

public class InfixCalculator {

    private String expression;

    public InfixCalculator(String expression) {
        this.expression = expression;
    }

    public String calculate() throws UnsupportedOperationException {

        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sb.append(tokens[i++]);
                }
                i--;
                values.push(Integer.parseInt(sb.toString()));
            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            }else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }

        }

        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        return String.valueOf(values.pop());
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    private int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Invalid Syntax");
                return a / b;
        }
        return 0;
    }
}
