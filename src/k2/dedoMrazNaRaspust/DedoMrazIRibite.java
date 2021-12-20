package k2.dedoMrazNaRaspust;

import java.util.Scanner;

public class DedoMrazIRibite {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int U = in.nextInt();
        Graph<Integer> g = new Graph<>(N);
        for (int i = 0; i < U; i++) {
            int r = in.nextInt();
            int q = in.nextInt();
            g.addEdge(r, q);

        }
        int L = in.nextInt();
        System.out.println(g.sendFishes(L));
        System.out.println("Srekna Nova Godina");
        in.close();
    }
}