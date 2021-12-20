package k2.vkupenBrojNaPatista;

import java.io.*;

public class PathCount {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph<Integer> g = new Graph<>(N);
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String edgeLine[] = line.split(" ");
            g.addEdge(Integer.parseInt(edgeLine[0]), Integer.parseInt(edgeLine[1]));
        }
        int nodeIndex = Integer.parseInt(br.readLine());
        int pathLength = Integer.parseInt(br.readLine());
        System.out.println(g.pathCount(nodeIndex, pathLength));
        br.close();

    }
}