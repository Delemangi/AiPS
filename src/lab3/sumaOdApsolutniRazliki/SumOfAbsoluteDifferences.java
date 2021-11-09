package lab3.sumaOdApsolutniRazliki;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfAbsoluteDifferences {
    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();
    }

    static int solve(int[] array, int N, int K) {
        int[][] dp = new int[N][K];
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < K; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + Math.abs(array[i] - array[k]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max;
    }
}