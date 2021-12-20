package k2.rastojanieVoDrvo;

import java.io.*;
import java.util.*;

public class NodeDistance {
    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<String> nodes[] = new BNode[N];
        BTree<String> tree = new BTree<String>();

        for (i = 0; i < N; i++)
            nodes[i] = new BNode<String>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
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

        int cases = Integer.parseInt(br.readLine());
        for (int l = 0; l < cases; l++) {
            String split[] = br.readLine().split(" +");
            String from = split[0];
            String to = split[1];

            if (findNode(tree.root, from) == null || findNode(tree.root, to) == null) {
                System.out.println("ERROR");
            } else if (from.equals(to)) {
                System.out.println("0");
            } else {
                BNode<String> fromNode = findNode(tree.root, from);
                BNode<String> toNode = findNode(tree.root, to);

                System.out.println(2 * (getDistance(tree.root, fromNode, 0) + getDistance(tree.root, toNode, 0) - 2 * getDistance(tree.root, getLCA(tree.root, fromNode, toNode, 0), 0)));
            }
        }

        br.close();
    }

    public static BNode<String> findNode(BNode<String> root, String str) {
        if (root == null) {
            return null;
        }

        if (root.info.equals(str)) {
            return root;
        }

        BNode<String> node = findNode(root.left, str);

        return node != null ? node : findNode(root.right, str);
    }

    public static int getDistance(BNode<String> root, BNode<String> node, int i) {
        if (root == null) {
            return -1;
        }

        if (root == node) {
            return i;
        }

        int d = getDistance(root.left, node, i + 1);

        return d != -1 ? d : getDistance(root.right, node, i + 1);
    }

    public static BNode<String> getLCA(BNode<String> root, BNode<String> node1, BNode<String> node2, int i) {
        if (root == null) {
            return null;
        }

        if (root == node1 || root == node2) {
            return root;
        }

        BNode<String> left = getLCA(root.left, node1, node2, i + 1);
        BNode<String> right = getLCA(root.right, node1, node2, i + 1);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}