package k2.proverkaNaValidnost;

import java.io.*;
import java.util.*;

public class ValidityCheck {
    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<Integer> nodes[] = new BNode[N];
        BTree<Integer> tree = new BTree<Integer>();

        for (i = 0; i < N; i++)
            nodes[i] = new BNode<Integer>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = Integer.parseInt(st.nextToken());
            action = st.nextToken();
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

        System.out.println(validTree(tree.root));
    }

    public static boolean validTree(BNode<Integer> root) {
        if (root == null) {
            return true;
        }

        if ((root.left != null && root.left.info > root.info) || (root.right != null && root.right.info > root.info)) {
            return false;
        }

        return validTree(root.left) && validTree(root.right);
    }
}