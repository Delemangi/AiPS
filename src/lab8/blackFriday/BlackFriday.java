package lab8.blackFriday;

import java.io.*;

public class BlackFriday {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] tokens = line.split("(:|\\s+)");

            int time = Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]);
            int duration = Integer.parseInt(tokens[2]);

            bst.insert(time);
            bst.find(time).type = 1;

            bst.insert(time + duration);
            bst.find(time + duration).type = 2;
        }

        bst.maxCustomers();
        System.out.println(bst.max);

        br.close();
    }
}