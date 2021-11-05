package k1.matematickiIzraz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

    public static int evaluateExpression(String expression) {
        Stack<Character> exp = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                exp.push(expression.charAt(i));
            } else if (expression.charAt(i) == '*') {

            }
        }


    }
}