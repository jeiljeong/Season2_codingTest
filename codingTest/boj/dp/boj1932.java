package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1932 {
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
        System.out.println(route(0));
        
        // 3. End
    }

    private static int route(int depth) {
        if (depth == n) {
            return 0;
        }

        if (dp[depth] < 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= depth; i++) {
                max = Math.max(max, triangle[depth][i]);
            }
            dp[depth] = max + route(depth + 1);
        }

        return dp[depth];
    }

    private static void printTest(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append(triangle[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
