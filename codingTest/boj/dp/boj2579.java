package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Point
 * 1) In the stair calculation, there are scenarios
 *    - if you wanna store the dp value of n index, then you find
 *      a. that you step the n - 2 stair, it means 2 step jump
 *      b. or that you step the n - 3 stair and n - 1 stair, it means 1 step jump
 *         - but the important thing is you should apply the recursion only to n - 3 stair, because if you apply the n - 1 stair
 *           then it becomes n - 1, n - 2, n - 3 sequencial recursion.
 * 2) Thus, two point is key point
 *    - First, recurrence relation n - 2, n - 1
 *    - Second, recursion for n - 2, n - 3 related to n - 2 recurrence relation
 */
public class boj2579 {
    private static int[] step;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        step = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }
        
        // 2. Biz logic
        dp[0] = step[0];
        if (n >= 2) {
            dp[1] = step[0] + step[1];
        }
        
        // 3. End
        System.out.println(maxStep(n - 1));
    }

    private static int maxStep(int idx) {
        if (idx < 0) {
            return 0;
        }
        
        if (dp[idx] == 0) {
            dp[idx] = Math.max(maxStep(idx - 2), maxStep(idx - 3) + step[idx - 1]) + step[idx];
        }
    
        return dp[idx];
    }
}
