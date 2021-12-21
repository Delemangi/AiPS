package lab8.posledovatelniBroevi;

import java.io.*;

public class ConsecutiveNumbers {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            BTree<Integer> bTree = new BTree<>();
            int n = Integer.parseInt(input.readLine());
            BNode<Integer>[] nodes = (BNode<Integer>[]) new BNode[n];

            for (int i = 0; i < n; ++i) {
                String[] lineParts = input.readLine().split("\\s+");
                int index = Integer.parseInt(lineParts[0]);
                int data = Integer.parseInt(lineParts[1]);
                String where = lineParts[2];
                if (where.equals("ROOT")) {
                    nodes[index] = bTree.makeRoot(data);
                } else {
                    int nodePosition = Integer.parseInt(lineParts[3]);
                    int whereInt = 1;
                    if (where.equals("RIGHT"))
                        whereInt = 2;
                    nodes[index] = bTree.addChild(nodes[nodePosition], whereInt, data);
                }
            }

            System.out.println(consecutiveNumbers(bTree));
        }
    }

    public static boolean consecutiveNumbers(BTree<Integer> tree) {
        if (tree.head.ltag == '-') {
            return true;
        }

        BNode<Integer> node = tree.head.left;

        while (node.ltag == '+') {
            node = node.left;
        }

        while (node != tree.head) {
            if (tree.successorInorder(node).info != null && tree.successorInorder(node).info - node.info != 1) {
                return false;
            }

            node = tree.successorInorder(node);
        }

        return true;
    }
}