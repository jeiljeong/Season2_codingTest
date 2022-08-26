package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This version uses the dynamic programming & Pascal's triangle,
 * But there is another version using factiorial and Fermat's little theorem.
 * cf. https://st-lab.tistory.com/162
 */
public class boj11051_v3 {
    private static int[][] dp;
    private static final int div = 10007;

    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1];

        // 2. Biz logic
        
        // 3. End
        System.out.println(binomialCoeffcient(n, k));
    }

    private static int binomialCoeffcient(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (k == 0 || n == k) {
            return dp[n][k] = 1;
        }
        return dp[n][k] = (binomialCoeffcient(n - 1, k -1) + binomialCoeffcient(n - 1, k)) % div;
    }
}
