package k2.vkupenBrojNaPatista;

public class Graph<E> {
    int num_nodes; // broj na jazli
    E nodes[]; // informacija vo jazlite - moze i ne mora?
    int adjMat[][]; // matrica na sosednost

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes) {
        this.num_nodes = num_nodes;
        nodes = (E[]) new Object[num_nodes];
        adjMat = new int[num_nodes][num_nodes];

        for (int i = 0; i < this.num_nodes; i++)
            for (int j = 0; j < this.num_nodes; j++)
                adjMat[i][j] = 0;
    }

    int adjacent(int x, int y) { // proveruva dali ima vrska od jazelot so
        // indeks x do jazelot so indeks y
        return (adjMat[x][y] != 0) ? 1 : 0;
    }

    void addEdge(int x, int y) { // dodava vrska megu jazlite so indeksi x i y
        adjMat[x][y] = 1;
        adjMat[y][x] = 1;
    }

    void deleteEdge(int x, int y) {
        // ja brise vrskata megu jazlite so indeksi x i y
        adjMat[x][y] = 0;
        adjMat[y][x] = 0;
    }

    E get_node_value(int x) { // ja vraka informacijata vo jazelot so indeks x
        return nodes[x];
    }

    void set_node_value(int x, E a) { // ja postavuva informacijata vo jazelot
        // so indeks na a
        nodes[x] = a;
    }

    @Override
    public String toString() {
        String ret = "  ";
        for (int i = 0; i < num_nodes; i++)
            ret += nodes[i] + " ";
        ret += "\n";
        for (int i = 0; i < num_nodes; i++) {
            ret += nodes[i] + " ";
            for (int j = 0; j < num_nodes; j++)
                ret += adjMat[i][j] + " ";
            ret += "\n";
        }
        return ret;
    }

    public void printMatrix() {
        for (int i = 0; i < num_nodes; i++) {
            for (int j = 0; j < num_nodes; j++)
                System.out.print(adjMat[i][j] + " ");
            System.out.println();
        }
    }

    public int pathCount(int nodeIndex, int pathLength) {
        if (pathLength == 0) {
            return 1;
        }

        int a = 0;

        for (int i = 0; i < adjMat[nodeIndex].length; i++) {
            if (adjMat[nodeIndex][i] == 1) {
                a += pathCount(i, pathLength - 1);
            }
        }

        return a;
    }
}