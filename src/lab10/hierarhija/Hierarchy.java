package lab10.hierarhija;

import java.io.*;

public class Hierarchy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Integer[] info = new Integer[N];

        for (int i = 0; i < N; i++) {
            info[i] = i;
        }

        Graph<Integer> graph = new Graph<>(N, info);

        for (int i = 0; i < M; i++) {
            String[] tokens = br.readLine().split("\\s+");
            graph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[4]));
        }

        System.out.println((int) graph.kruskal().stream().mapToDouble(Edge::getWeight).sum());
    }
}