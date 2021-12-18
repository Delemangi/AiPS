package lab7.zbirNaElementiVoBinarnoDrvo;

import java.io.*;
import java.util.*;

public class BinaryTreeSum {
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

        int baranaVrednost = Integer.parseInt(br.readLine());

        br.close();

        BNode<Integer> root = findNode(tree.root, baranaVrednost);

        System.out.printf("%d %d", sumNodes(root.left, baranaVrednost, '<'), sumNodes(root.right, baranaVrednost, '>'));
    }

    public static BNode<Integer> findNode(BNode<Integer> root, int e) {
        BNode<Integer> node;

        if (root == null) {
            return null;
        }

        if (root.info == e) {
            return root;
        }

        node = findNode(root.left, e);

        if (node == null) {
            node = findNode(root.right, e);
        }

        return node;
    }

    public static int sumNodes(BNode<Integer> root, int e, char c) {
        if (root == null) {
            return 0;
        }

        if (c == '<') {
            if (root.info < e) {
                return root.info + sumNodes(root.left, e, c) + sumNodes(root.right, e, c);
            } else {
                return sumNodes(root.left, e, c) + sumNodes(root.right, e, c);
            }
        } else {
            if (root.info > e) {
                return root.info + sumNodes(root.left, e, c) + sumNodes(root.right, e, c);
            } else {
                return sumNodes(root.left, e, c) + sumNodes(root.right, e, c);
            }
        }
    }
}