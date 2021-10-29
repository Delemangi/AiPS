package k1.najdolgaOpagjackaSekvenca;

import java.util.Scanner;

public class LDS {
    private static int najdolgaOpagackaSekvenca(int[] a) {
        int min = -1;
        int index = -1;
        int count = 1;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                min = a[i];
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < a.length - 1; i++) {
                if (min > a[i + 1]) {
                    count++;
                    min = a[i + 1];
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }
}