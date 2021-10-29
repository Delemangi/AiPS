package k1.opseg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Range {
    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long res = proveri(N, A, B);
        System.out.println(res);

        br.close();
    }

    static long proveri(long N, long A, long B) {
        long x = (A + B) / 2;
        long check = x * x + digits(x) + 200 * x;

        if (check == N) {
            return x;
        } else if (A == B) {
            return -1;
        } else if (B - A == 1) {
            return proveri(N, B, B);
        } else if (check < N) {
            return proveri(N, x, B);
        } else {
            return proveri(N, A, x);
        }
    }

    static int digits(long n) {
        int z = 0;

        while (n != 0) {
            z += n % 10;
            n /= 10;
        }

        return z;
    }
}
