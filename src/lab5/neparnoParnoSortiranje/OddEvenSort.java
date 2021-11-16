package lab5.neparnoParnoSortiranje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {
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
        oddEvenSort(a, n);
        for (i = 0; i < n - 1; i++)
            System.out.print(a[i] + " ");
        System.out.print(a[i]);
    }

    static void oddEvenSort(int a[], int n) {
        int even = 0;
        int odd = 0;
        int temp;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int[] evenArray = new int[even];
        int[] oddArray = new int[odd];

        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                oddArray[k++] = a[i];
            }
        }

        k = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                evenArray[k++] = a[i];
            }
        }

        for (int i = 0; i < oddArray.length - 1; i++) {
            for (int j = 0; j < oddArray.length - 1 - i; j++) {
                if (oddArray[j] > oddArray[j + 1]) {
                    temp = oddArray[j];
                    oddArray[j] = oddArray[j + 1];
                    oddArray[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < evenArray.length - 1; i++) {
            for (int j = 0; j < evenArray.length - 1 - i; j++) {
                if (evenArray[j] < evenArray[j + 1]) {
                    temp = evenArray[j];
                    evenArray[j] = evenArray[j + 1];
                    evenArray[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < oddArray.length; i++) {
            a[i] = oddArray[i];
        }

        for (int i = 0; i < evenArray.length; i++) {
            a[i + oddArray.length] = evenArray[i];
        }
    }
}