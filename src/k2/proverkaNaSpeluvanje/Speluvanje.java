package k2.proverkaNaSpeluvanje;

import java.io.*;

public class Speluvanje {
    public static void main(String[] args) throws IOException {
        OBHT<Zbor, String> tabela;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tabela = new OBHT<Zbor, String>(2 * N);

        for (int i = 0; i < N; i++) {
            tabela.insert(new Zbor(br.readLine()), "a");
        }

        String text = br.readLine();
        String[] words = text.split("\\s+");
        boolean flag = true;

        if (words.length == 1) {
            System.out.println("Bravo");
            return;
        }

        for (String word : words) {
            word = word.replaceAll("[.,!?]", "").toLowerCase();

            int search = tabela.search(new Zbor(word));

            if (search == -1) {
                flag = false;
                System.out.println(word);
            }
        }

        if (flag) {
            System.out.println("Bravo");
        }

        br.close();
    }
}