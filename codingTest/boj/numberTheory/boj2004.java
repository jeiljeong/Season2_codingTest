package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * There is no problem in solving logic Binomial Coefficient,
 * but divide by 5 algorithm cannot be used in this problem.
 * Because divide by 5 is for factorial n, but in this problem bc means result of factorial operation.
 * Thus, in the version2, I will follow below blog posting. 
 * 
 * cf. https://st-lab.tistory.com/166
 */
public class boj2004 {
    private static long[][] dp;
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        dp = new long[n + 1][m + 1];
        // 2. Biz logic
        long bc = binomialCoefficient(n, m);

        long count = 0;
        while (bc >= 5) {
            count += bc / 5;
            bc /= 5;
        }

        // 3. End
        System.out.println(count);
    }

    private static long binomialCoefficient(int n, int m) {
        if (dp[n][m] > 0) {
            return dp[n][m];
        }

        if (n == m || m == 0) {
            return dp[n][m] = 1;
        }

        return dp[n][m] = binomialCoefficient(n - 1, m - 1)
                        + binomialCoefficient(n - 1, m);
    }
}
