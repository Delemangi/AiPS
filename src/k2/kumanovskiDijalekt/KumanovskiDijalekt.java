package k2.kumanovskiDijalekt;

import java.io.*;

public class KumanovskiDijalekt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        CBHT<String, String> cbht = new CBHT<>(2 * N);

        String rechnik[] = new String[N];
        for (int i = 0; i < N; i++) {
            rechnik[i] = br.readLine();
        }

        for (String s : rechnik) {
            String[] split = s.split("\\s+");

            cbht.insert(split[0], split[1]);
        }

        String tekst = br.readLine();

        String[] words = tekst.split("\\s+");

        if (N == 0) {
            System.out.println(tekst);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            String key;
            boolean punctuation = false;
            boolean uppercase = false;
            char last = words[i].charAt(words[i].length() - 1);

            if (last == '.' || last == ',' || last == '!' || last == '?') {
                key = words[i].substring(0, words[i].length() - 1);
                punctuation = true;
            } else {
                key = words[i];
            }

            if (Character.isUpperCase(key.charAt(0))) {
                key = key.toLowerCase();
                uppercase = true;
            }

            SLLNode<MapEntry<String, String>> search = cbht.search(key);

            if (search != null) {
                String value = search.element.value;

                if (punctuation) {
                    value += last;
                }

                if (uppercase) {
                    value = Character.toUpperCase(value.charAt(0)) + value.substring(1);
                }

                words[i] = value;
            }
        }

        for (String word : words) {
            System.out.printf("%s ", word);
        }
    }
}