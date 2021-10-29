package k1.vojska;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DLLVojska {
    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] ids = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(ids[i]));
        }

        s = stdin.readLine();
        String interval[] = s.split(" ");
        int a = Integer.parseInt(interval[0]);
        int b = Integer.parseInt(interval[1]);

        s = stdin.readLine();
        interval = s.split(" ");
        int c = Integer.parseInt(interval[0]);
        int d = Integer.parseInt(interval[1]);


        DLL<Integer> result = vojska(lista, a, b, c, d);


        DLLNode<Integer> node = result.getFirst();
        System.out.print(node.element);
        node = node.succ;
        while (node != null) {
            System.out.print(" " + node.element);
            node = node.succ;
        }
    }

    private static DLL<Integer> vojska(DLL<Integer> lista, int a, int b, int c, int d) {
        DLLNode<Integer> A = null;
        DLLNode<Integer> B = null;
        DLLNode<Integer> C = null;
        DLLNode<Integer> D = null;
        DLLNode<Integer> N = lista.getFirst();

        while (N != null) {
            if (N.element == a) {
                A = N;
            }
            if (N.element == b) {
                B = N;
            }
            if (N.element == c) {
                C = N;
            }
            if (N.element == d) {
                D = N;
            }
            N = N.succ;
        }

        DLLNode<Integer> AP = A.pred;
        DLLNode<Integer> BS = B.succ;
        DLLNode<Integer> CP = C.pred;
        DLLNode<Integer> DS = D.succ;

        lista.deleteList();

        if (AP != null) {
            while (AP != null) {
                lista.insertFirst(AP.element);
                AP = AP.pred;
            }
        }

        while (C != D.succ) {
            lista.insertLast(C.element);
            C = C.succ;
        }

        if (BS != CP) {
            while (BS != CP.succ) {
                lista.insertLast(BS.element);
                BS = BS.succ;
            }
        }

        while (A != B.succ) {
            lista.insertLast(A.element);
            A = A.succ;
        }

        if (DS != null) {
            while (DS != null) {
                lista.insertLast(DS.element);
                DS = DS.succ;
            }
        }

        return lista;
    }
}