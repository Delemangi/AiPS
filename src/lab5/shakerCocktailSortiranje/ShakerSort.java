package lab5.shakerCocktailSortiranje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {
    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(pom[i]);
        shakerSort(a, n);
    }

    static void shakerSort(int a[], int n) {
        int temp;
        boolean flag = true;

        for (int i = 0; flag; i++) {
            flag = false;

            for (int j = n - 2 - i; j >= i; j--) {
                if (a[j] > a[j + 1]) {
                    flag = true;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            print(a);

            for (int j = i; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    flag = true;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            print(a);
        }
    }

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}