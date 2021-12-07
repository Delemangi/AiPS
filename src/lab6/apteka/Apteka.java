package lab6.apteka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apteka {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        CBHT<String, Medicine> cbht = new CBHT<>(2 * N);

        for (int i = 0; i < N; ++i) {
            String[] split = br.readLine().split("\\s+");
            Medicine med = new Medicine(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
            cbht.insert(med.name.toUpperCase(), med);
        }

        String line;
        while (true) {
            line = br.readLine();

            if (line.equals("KRAJ")) {
                break;
            }

            SLLNode<MapEntry<String, Medicine>> search = cbht.search(line.toUpperCase());
            int quantity = Integer.parseInt(br.readLine());

            if (search != null) {
                Medicine med = search.element.value;

                System.out.println(med);

                if (med.order(quantity)) {
                    System.out.println("Napravena naracka");
                } else {
                    System.out.println("Nema dovolno lekovi");
                }
            } else {
                System.out.println("Nema takov lek");
            }
        }
    }
}