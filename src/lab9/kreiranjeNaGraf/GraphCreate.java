package lab9.kreiranjeNaGraf;

import java.io.*;

public class GraphCreate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Graph<String> graph = null;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "CREATE":
                    int n = Integer.parseInt(tokens[1]);
                    String[] nodes = new String[n];

                    for (int j = 0; j < n; j++) {
                        nodes[j] = String.valueOf((char) ('A' + j));
                    }

                    graph = new Graph<>(n, nodes);

                    break;
                case "ADDEDGE":
                    graph.addEdge(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));

                    break;
                case "DELETEEDGE":
                    graph.deleteEdge(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));

                    break;
                case "ADJACENT":
                    System.out.println(graph.adjacent(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));

                    break;
                case "PRINTMATRIX":
                    for (int j = 0; j < graph.num_nodes; j++) {
                        for (int k = 0; k < graph.num_nodes; k++) {
                            System.out.print(graph.adjMat[j][k] + " ");
                        }
                        System.out.println();
                    }

                    break;
                case "PRINTNODE":
                    System.out.println(graph.get_node_value(Integer.parseInt(tokens[1])));

                    break;
                default:
                    break;
            }
        }
    }
}