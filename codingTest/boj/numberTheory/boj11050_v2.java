package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Factorial formula optimization version
 * 
 * step 1 : use of Pascal's triangle
 * step 2 : use of recursion
 * step 3 : use of Dynamic Programming
 * 
 * cf. https://st-lab.tistory.com/159
 */

public class boj11050_v2 {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
       // 1. Check input validation & initialization
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       int n = Integer.parseInt(st.nextToken());
       int k = Integer.parseInt(st.nextToken());

       // 2. Biz logic
       
       dp = new int[n + 1][k + 1];
       
       // 3. End
       System.out.println(binomialCoeffcient(n, k));
    }

    private static int binomialCoeffcient(int n, int k) {
        // 1. Is it already solved problem?
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        // 2. Properties of Binomial Coefficient & Stop index of recursion
        if (k == 0 || n == k) {
            return dp[n][k] = 1;
        }

        //  3. Pascal's triangle by usage of recursion
        return dp[n][k] = binomialCoeffcient(n - 1, k - 1)
                        + binomialCoeffcient(n - 1, k);
    }
}
