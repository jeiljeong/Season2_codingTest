import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Point
 * 1) bruteForce
 * 2) DP
 * cf. https://st-lab.tistory.com/128
 */
public class boj1149_v3 {
    private static int[][] cost;
    private static int[][] dp;
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        cost = new int[n][3];
        dp =  new int[n][3];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 2. Biz logic
        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];
        
        // 3. End
        System.out.println(Math.min(Math.min(colorCost(n - 1, RED), colorCost(n - 1, GREEN)), colorCost(n - 1, BLUE)));
    }

    private static int colorCost(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == RED) {
                dp[n][RED] = Math.min(colorCost(n - 1, GREEN), colorCost(n - 1, BLUE)) + cost[n][RED];
            }
            else if (color == GREEN) {
                dp[n][GREEN] = Math.min(colorCost(n - 1, RED), colorCost(n - 1, BLUE)) + cost[n][GREEN];
            }
            else if (color == BLUE) {
                dp[n][BLUE] = Math.min(colorCost(n - 1, RED), colorCost(n - 1, GREEN)) + cost[n][BLUE];
            }
        }

        return dp[n][color];
    }

}
