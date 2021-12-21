package k2.patarini;

import java.io.*;

public class Paytolls {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] split = str.split("\\s+");
        int A = Integer.parseInt(split[0]) - 1;
        int B = Integer.parseInt(split[1]) - 1;
        int M = Integer.parseInt(br.readLine());

        Integer[] edges = new Integer[M];

        for (int i = 0; i < M; i++) {
            edges[i] = i;
        }

        Graph<Integer> graph = new Graph<>(N, edges);

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] tokens = line.split("\\s+");

            int X = Integer.parseInt(tokens[0]) - 1;
            int Y = Integer.parseInt(tokens[1]) - 1;
            int W = Integer.parseInt(tokens[2]);

            graph.addEdge(X, Y, W);
            graph.addEdge(Y, X, W);
        }

        System.out.println((int) graph.dijkstra(A)[B]);

        br.close();
    }
}