package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj24416_v2 {
    private static int dp[];
    private static int recursionCallCnt = 0;
    private static int dpCallCnt = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        
        // 2. Biz logic
        fibonacciRecursion(n);

        dp[1] = 1;
        dp[2] = 1;
        fibonacciDp(n);
        
        // 3. End
        System.out.println(recursionCallCnt);
        System.out.println(dpCallCnt);
    }

    private static int fibonacciDp(int n) {
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dpCallCnt++;
        }
        return dp[n];
    }

    private static int fibonacciRecursion(int n) {
        if (n == 1 || n == 2) {
            recursionCallCnt++;
            return 1;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }
}
