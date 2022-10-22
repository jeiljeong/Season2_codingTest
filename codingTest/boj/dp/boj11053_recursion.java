import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11053_recursion {
    private static int nums[];
    private static Integer dp[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        dp = new Integer[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = nums[0];

        // 2. Biz logic
        // 모든 원소에 대한 부분 수열을 구해야 함
        for (int i = 1; i <= n; i++) {
            lis(i);
        }
        
        // 3. End
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }

    private static int lis(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] < nums[n]) {
                    dp[n] = Math.max(dp[n], lis(i) + 1);
                }
            }
        }
        return dp[n];
    }
}
