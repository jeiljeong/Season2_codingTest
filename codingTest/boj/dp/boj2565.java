import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2565 {
    private static int line[];
    private static Integer dp[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. initialize
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        line = new int[500 + 1];
        dp = new Integer[n + 1];

        StringTokenizer st = null;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[a] = b;
        }

        dp[0] = 0;

        int[] sorted_line = new int[n + 1];

        int idx = 1;
        for (int i = 1; i <= 500; i++) {

            if (line[i] == 0) {
                continue;
            }
            sorted_line[idx] = line[i];
            idx++;
        }

        // 2. logic
        // from sorted_line_1 to sorted_line_2
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            
            for (int j = 1; j < i; j++) {
                if (sorted_line[i] >= sorted_line[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // 3. end
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }    
}