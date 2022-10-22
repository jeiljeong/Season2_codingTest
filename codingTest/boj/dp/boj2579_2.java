import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 점화식 구성과 Memorization의 대상을 찾는 것이 가장 어려움
 */
/**
 * 1) n번째(마지막) 계단은 항상 밟음
 * 2) 직전 계단은 arr 접근, 마지막+직전 계단으로 연속 2계단을 밟았기에 find(n - 3)
 * 3) find(n - 2)로 점프한 후 n번째 계단 밟는 경우 계산
 */
public class boj2579_2 {
    private static int[] arr;
    private static Integer dp[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());    
        }

        // dp 초기화
        dp[0] = 0;
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        // 2. Biz logic
        int result = find(n);
        
        // 3. End
        System.out.println(result);
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(find(n - 2), find(n - 3) + arr[n - 1]) + arr[n];
        }
        return dp[n];
    }
}
