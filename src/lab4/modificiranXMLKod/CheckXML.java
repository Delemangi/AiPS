package lab4.modificiranXMLKod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckXML {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] redovi = new String[n];

        for (int i = 0; i < n; i++)
            redovi[i] = br.readLine();

        int valid = 1;

        ArrayStack<String> stack = new ArrayStack<String>(n);

        for (int i = 0; i < n; i++) {
            if (redovi[i].charAt(0) == '[') {
                if (redovi[i].charAt(1) == '/') {
                    if (!stack.peek().equals(redovi[i].substring(2, redovi[i].length() - 1))) {
                        valid = 0;
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(redovi[i].substring(1, redovi[i].length() - 1));
                }
            }
        }

        System.out.println(valid);

        br.close();
    }
}