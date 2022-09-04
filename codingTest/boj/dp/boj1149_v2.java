package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * cf. https://st-lab.tistory.com/128
 */
public class boj1149_v2 {
    private final static int RED = 0;
    private final static int GREEN = 1;
    private final static int BLUE = 2;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. Biz logic
        for (int i = 1; i < n; i++) {
            cost[i][RED]    += Math.min(cost[i - 1][GREEN]  , cost[i - 1][BLUE]);
            cost[i][GREEN]  += Math.min(cost[i - 1][RED]    , cost[i - 1][BLUE]);
            cost[i][BLUE]   += Math.min(cost[i - 1][RED]    , cost[i - 1][GREEN]);
        }
        
        // 3. End
        int answer = Math.min(cost[n - 1][RED], cost[n - 1][GREEN]);
        answer = Math.min(cost[n - 1][BLUE], answer);
        System.out.println(answer);
    }
}
