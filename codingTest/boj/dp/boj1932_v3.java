package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Point
 * 1) dynamic programming can be succeed by using memorization
 *    - Thus, usally the solving way is related with static field.
 * 2) backTracking is related with recursion & checking condition
 *    - Thus, the backTracking combined with the dynamic programming looks like when the condition is enough, then return memorized value
 *    - Furthermore, the check of visiting is processed by memorization section has the init value of backTracking
 *    - So, the backTracking with the recursion has
 *      a. depth condition
 *      b. is visited condition with init value
 *      c. if the memorized value exists, then return it
 *      d. or not, then calcuate some of the operations and reserve the result value
 * 3) The backTracking seems like the bruteforce, but the bruteforce doesn't have any exit condition
 * 4) The backTracking is implemented by the recursion or the iteration related to dfs, bfs
 *    - The recursion is the way of depth down and the way of top-down
 *    - The iteration is the way of accumulation and the way of bottom-up
 * 5) Additionally, be careful with some of the tricky conditions like int overflow, underflow
 */
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
