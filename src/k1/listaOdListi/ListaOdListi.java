package k1.listaOdListi;

import java.util.Scanner;

public class ListaOdListi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        DLLNode<DLL<Integer>> first = list.getFirst();

        long p = 1;

        while (first != null) {
            DLL<Integer> currentList = first.element;
            DLLNode<Integer> node = currentList.getFirst();

            long totalCurrent = 0;

            while (node != null) {
                totalCurrent += node.element;
                node = node.succ;
            }

            p *= totalCurrent;
            first = first.succ;
        }

        return p;
    }
}