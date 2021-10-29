package k1.palindrom;

import java.util.Scanner;

public class PalindromeDLL {
    public static int isItPalindrome(DLL<Integer> list) {
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();

        while (first != last) {
            if (first.element == last.element) {
                first = first.succ;
                last = last.pred;
            } else {
                return -1;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        in.close();
        System.out.println(isItPalindrome(list));
    }
}