package lab4.postfiksNotacija;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PostFixEvaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char[] exp = expression.toCharArray();

        br.close();

        System.out.println(evaluate(exp));
    }

    public static int evaluate(char[] str) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(str.length);
        String buffer = "";

        for (int i = 0; i < str.length; i++) {
            if (Character.isDigit(str[i])) {
                buffer += str[i];
            } else if (str[i] == ' ' && !buffer.isEmpty()) {
                stack.push(Integer.parseInt(buffer));
                buffer = "";
            } else if (str[i] != ' ') {
                int a = stack.pop();
                int b = stack.pop();

                if (str[i] == '+') {
                    stack.push(b + a);
                } else if (str[i] == '-') {
                    stack.push(b - a);
                } else if (str[i] == '*') {
                    stack.push(b * a);
                } else if (str[i] == '/') {
                    if (b == 0) {
                        stack.push(0);
                    } else {
                        stack.push(b / a);
                    }
                }
            }
        }

        return stack.pop();
    }
}