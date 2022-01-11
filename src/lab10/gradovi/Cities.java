package lab10.gradovi;

import java.io.*;

public class Cities {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Integer[] info = new Integer[N];

        for (int i = 0; i < N; i++) {
            info[i] = i;
        }

        Graph<Integer> graph = new Graph<>(N, info);
        CBHT<String, Integer> cities = new CBHT<>(2 * N);
        CBHT<Integer, String> indexes = new CBHT<>(2 * N);

        for (int i = 0; i < M; i++) {
            String[] tokens = br.readLine().split("\\s+");

            graph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[2]), Float.parseFloat(tokens[4]));
            cities.insert(tokens[1], Integer.parseInt(tokens[0]));
            cities.insert(tokens[3], Integer.parseInt(tokens[2]));

            indexes.insert(Integer.parseInt(tokens[0]), tokens[1]);
            indexes.insert(Integer.parseInt(tokens[2]), tokens[3]);
        }

        int from = cities.search(br.readLine()).element.value;
        int to = cities.search(br.readLine()).element.value;

        Pair pair1 = graph.dijkstra(from);
        Pair pair2 = graph.dijkstra(to);

        path(pair1.a, indexes, to);
        System.out.println();
        path(pair2.a, indexes, from);
        System.out.println();
        System.out.println(pair1.b[to] + pair2.b[from]);
    }

    public static void path(int[] parents, CBHT<Integer, String> cbht, int i) {
        if (parents[i] == i) {
            System.out.print(cbht.search(i).element.value + " ");
            return;
        }

        path(parents, cbht, parents[i]);

        System.out.print(cbht.search(i).element.value + " ");
    }
}