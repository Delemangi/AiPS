package lab6.lozinki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lozinki {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        CBHT<String, String> cbht = new CBHT<>(31);

        for (int i = 1; i <= N; i++) {
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
            cbht.insert(pom[0], pom[1]);
        }

        while (true) {
            String line = br.readLine();

            if (line.equals("KRAJ")) {
                break;
            }

            String[] split = line.split("\\s+");
            SLLNode<MapEntry<String, String>> pw = cbht.search(split[0]);

            if (pw != null && split[1].equals(pw.element.value)) {
                System.out.println("Najaven");
                break;
            } else {
                System.out.println("Nenajaven");
            }
        }
    }
}