package lab6.preveduvac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Preveduvac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        OBHT<String, String> obht = new OBHT<>(2 * N);

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String pom[] = s.split(" ");
            obht.insert(pom[1], pom[0]);
        }

        while (true) {
            String line = br.readLine();

            if (line.equals("KRAJ")) {
                break;
            }

            int word = obht.search(line);

            if (word != -1) {
                System.out.println(obht.buckets[word].value);
            } else {
                System.out.println("/");
            }
        }
    }
}