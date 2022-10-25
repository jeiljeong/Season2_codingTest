import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12865 {
    private static Integer[] dp;
    private static int[] num;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        num = new int[n + 1];
        
        int dp_size = n - k + 1;
        dp = new Integer[dp_size + 1];
        dp[0] = 0;
        dp[1] = 0;
        
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 2. Biz logic
        for (int i = 1; i <= k; i++) {
            dp[1] += num[i];
        }
        for (int i = 2; i <= dp_size; i++) {
            dp[i] = dp[i - 1] + num[i + k - 1] - num[i - 1];
        }        
        
        // 3. End
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= dp_size; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}