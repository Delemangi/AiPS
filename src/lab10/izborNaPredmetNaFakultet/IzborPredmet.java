package lab10.izborNaPredmetNaFakultet;

import lab1.patuvanje.Patuvanje;

import java.io.*;

public class IzborPredmet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] subjects = new String[N];
        CBHT<String, Integer> cbht = new CBHT<>(2 * N);

        for (int i = 0; i < N; i++) {
            String subject = br.readLine();

            subjects[i] = subject;
            cbht.insert(subject, i);
        }

        Graph<String> graph = new Graph<>(N, subjects);
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] tokens = br.readLine().split("\\s+");

            for (int j = 1; j < tokens.length; j++) {
                int key = cbht.search(tokens[0]).element.value;
                int value = cbht.search(tokens[j]).element.value;

                graph.addEdge(key, value);
            }
        }

        String lastSubject = br.readLine();
        int index = cbht.search(lastSubject).element.value;

        boolean[] passed = new boolean[N];
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(index);
        passed[index] = true;

        while (!queue.isEmpty()) {
            int k = queue.dequeue();

            for (int i = 0; i < N; i++) {
                if (graph.adjacent(k, i) == 1 && !passed[i]) {
                    queue.enqueue(i);
                    passed[i] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            boolean flag = false;
            if (!passed[i]) {
                for (int j = 0; j < N; j++) {
                    if (graph.adjacent(i, j) == 1 && !passed[j]) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    System.out.println(subjects[i]);
                    break;
                }
            }
        }
    }
}