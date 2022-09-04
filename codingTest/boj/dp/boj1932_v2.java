package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1932_v2 {
    private static int[][] triangle;
    private static int[] dp;
    private static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        triangle = new int[n][n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. Biz logic
        System.out.println(route(0, 0));
        
        // 3. End
    }
    private static int route(int depth, int idx) {
        if (depth == n || depth < idx) {
            return 0;
        }

        if (dp[depth] < 0) {
            int max = Math.max(route(depth + 1, idx), route(depth + 1, idx + 1));
            dp[depth] = max + triangle[depth][idx];
            System.out.println(triangle[depth][idx]);
        }
        
        return dp[depth];
    }
}
