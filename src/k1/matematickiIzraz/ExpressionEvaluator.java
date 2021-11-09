package k1.matematickiIzraz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpressionEvaluator {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

    public static int evaluateExpression(String str) {
        ArrayStack<Integer> stack = new ArrayStack<>(str.length());
        String buffer = "";
        char operator = '+';

        str += '+';

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                buffer += str.charAt(i);
            } else {
                if (operator == '*') {
                    stack.push(Integer.parseInt(buffer) * stack.pop());
                } else if (operator == '+') {
                    stack.push(Integer.parseInt(buffer));
                }

                buffer = "";
                operator = str.charAt(i);
            }
        }

        int s = 0;
        while (!stack.isEmpty()) {
            s += stack.pop();
        }

        return s;
    }
}