package k2.dedoVnukRelacii;

import java.io.*;
import java.util.*;

public class Relations {
    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<Integer> nodes[] = new BNode[N];
        BTree<Integer> tree = new BTree<Integer>();

        for (i = 0; i < N; i++) {
            nodes[i] = null;
        }

        for (i = 0; i < N; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            int index = Integer.parseInt(st.nextToken());
            nodes[index] = new BNode<Integer>(Integer.parseInt(st.nextToken()));
            String action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }

        br.close();

        // vasiot kod ovde
        System.out.println(tree.getNumberOfRelations());
    }
}