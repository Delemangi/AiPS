package lab5.sortiranjeSoMeurcinjaKajLista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSortLL {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");

        DLL<Integer> lista = new DLL<>();
        for (int i = 0; i < pomniza.length; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }
        bubbleSort(lista);
        print(lista);
    }

    public static void bubbleSort(DLL<Integer> list) {
        DLLNode<Integer> node = list.getFirst();
        DLLNode<Integer> it;
        int temp;

        while (node != null) {
            it = list.getFirst();

            while (it.succ != null) {
                if (it.element > it.succ.element) {
                    temp = it.element;
                    it.element = it.succ.element;
                    it.succ.element = temp;
                }

                it = it.succ;
            }

            node = node.succ;
        }
    }

    public static void print(DLL<Integer> list) {
        DLLNode<Integer> node = list.getFirst();

        while (node != null) {
            System.out.print(node.element + " ");
            node = node.succ;
        }
    }
}