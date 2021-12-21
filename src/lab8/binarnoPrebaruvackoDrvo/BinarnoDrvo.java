package lab8.binarnoPrebaruvackoDrvo;

import java.io.*;

public class BinarnoDrvo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            bst.insert(Integer.parseInt(br.readLine()));
        }
        int A = Integer.parseInt(br.readLine());

        int V = bst.getHeight(A);

        System.out.println(V);
        System.out.println(bst.getNodesAtDepth(V));

        br.close();
    }
}