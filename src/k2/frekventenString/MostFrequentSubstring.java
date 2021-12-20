package k2.frekventenString;

import java.io.*;

public class MostFrequentSubstring {
    public static void main(String[] args) throws IOException {
        CBHT<String, Integer> tabela = new CBHT<String, Integer>(300);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().trim();

        CBHT<String, Integer> cbht = new CBHT<>(word.length() * 2);

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String s = word.substring(i, j);

                if (cbht.search(s) == null) {
                    cbht.insert(s, 0);
                } else {
                    cbht.search(s).element.value++;
                }
            }
        }

        System.out.println(CBHT.mostFrequentSubstring(cbht));
    }
}