package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1932_v3 {
    private static int[][] triangle;
    private static int[][] dp;
    private static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
       
        triangle = new int[n][n];
        dp = new int[n][n];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                dp[i][j] = -1;
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. Biz logic
        
        // 3. End
        System.out.println(dp(0, 0));
    }

    private static int dp(int depth, int idx) {
        if (depth == n || depth < idx) {
            return 0;
        }

        if (dp[depth][idx] >= 0) {
            return dp[depth][idx];
        }

        return dp[depth][idx] = Math.max(dp(depth + 1, idx), dp(depth + 1, idx + 1)) + triangle[depth][idx];
    }
}
