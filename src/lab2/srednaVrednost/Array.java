package lab2.srednaVrednost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array<E> {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        int[] niza = new int[N];

        for (int i = 0; i < N; i++) {
            niza[i] = Integer.parseInt(stdin.readLine());
        }

        System.out.println(brojDoProsek(niza));
    }

    public static int brojDoProsek(int[] array) {
        double p = 0;
        double min = Double.MAX_VALUE;
        int z = array[0];

        for (int i = 0; i < array.length; i++) {
            p += array[i];
        }
        p /= array.length;

        for (int i = 0; i < array.length; i++) {
            if (Math.abs(p - array[i]) < min) {
                min = Math.abs(p - array[i]);
                z = array[i];
            } else if (Math.abs(p - array[i]) == min && array[i] < z) {
                z = array[i];
            }
        }

        return z;
    }
}