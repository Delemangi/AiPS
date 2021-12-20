package k2.komponentiNaSvrzanost;

import java.io.*;

public class KomponentiSvrzanost {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Graph<String> g = new Graph<String>(N);

        int sosedIndex;
        int i_num_nodes;
        String pom;
        for (int i = 0; i < N; i++) {
            i_num_nodes = Integer.parseInt(br.readLine());
            for (int j = 0; j < i_num_nodes; j++) {
                pom = br.readLine();
                sosedIndex = Integer.parseInt(pom);

                g.addEdge(i, sosedIndex);
            }
        }

        int teme = Integer.parseInt(br.readLine());
        int[] komponenti = g.najdikomponenti(teme);

        for (int i : komponenti) {
            System.out.println(i);
        }

        if (komponenti.length == 0) {
            System.out.println(teme);
        }

        br.close();
    }
}