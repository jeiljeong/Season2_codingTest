import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Longest Increasing Subsequence 문제
 * 1) O(n^2)의 문제
 */
public class boj11053_iter {
    private static int seq[];
    private static Integer dp[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        seq = new int[n + 1];
        dp = new Integer[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // 2. Biz logic
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (seq[i] > seq[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        // 3. End
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
