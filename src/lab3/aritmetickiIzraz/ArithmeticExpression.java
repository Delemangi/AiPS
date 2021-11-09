package lab3.aritmetickiIzraz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {
    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length - 1);
        System.out.println(rez);

        br.close();
    }

    static int presmetaj(char[] c, int l, int r) {
        if (l == r) {
            return Integer.parseInt(String.valueOf(c[l]));
        }

        int index = znak(c, l, r);

        if (c[index] == '+') {
            return presmetaj(c, l + 1, index - 1) + presmetaj(c, index + 1, r - 1);
        } else if (c[index] == '-') {
            return presmetaj(c, l + 1, index - 1) - presmetaj(c, index + 1, r - 1);
        } else {
            throw new IllegalArgumentException();
        }
    }

    static int znak(char[] c, int l, int r) {
        int depth = 0;

        for (int i = l; i <= r; i++) {
            if (depth == 1 && (c[i] == '+' || c[i] == '-'))
                return i;
            else if (c[i] == '(') {
                depth++;
            } else if (c[i] == ')') {
                depth--;
            }
        }

        throw new IllegalArgumentException();
    }
}