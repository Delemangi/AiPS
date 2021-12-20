package k2.komponentiNaSvrzanost;

import java.util.Arrays;

public class Graph<E> {
    int num_nodes;
    GraphNode<E> adjList[];

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            adjList[i] = new GraphNode<E>(i);
    }

    int adjacent(int x, int y) {
        // proveruva dali ima vrska od jazelot so
        // indeks x do jazelot so indeks y
        return (adjList[x].containsNeighbor(adjList[y])) ? 1 : 0;
    }

    void addEdge(int x, int y) {
        // dodava vrska od jazelot so indeks x do jazelot so indeks y
        if (!adjList[x].containsNeighbor(adjList[y])) {
            adjList[x].addNeighbor(adjList[y]);
        }
    }

    void deleteEdge(int x, int y) {
        adjList[x].removeNeighbor(adjList[y]);
    }

    int[] najdikomponenti(int start) {
        Queue<Integer> queue = new LinkedQueue<>();
        boolean[] visited = new boolean[num_nodes];

        queue.enqueue(start);

        while (!queue.isEmpty()) {
            int node = queue.dequeue();

            for (int i = 0; i < num_nodes; i++) {
                if (adjacent(node, i) == 1 && !visited[i]) {
                    queue.enqueue(i);
                    visited[i] = true;
                }
            }
        }

        int n = 0;

        for (int i = 0; i < num_nodes; i++) {
            if (visited[i]) {
                n++;
            }
        }

        int[] a = new int[n];
        int j = 0;

        for (int i = 0; i < num_nodes; i++) {
            if (visited[i]) {
                a[j++] = i;
            }
        }

        return a;
    }

    @Override
    public String toString() {
        String ret = new String();
        for (int i = 0; i < this.num_nodes; i++)
            ret += i + ": " + adjList[i] + "\n";
        return ret;
    }
}