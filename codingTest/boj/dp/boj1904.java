import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 메모리 초과
 * 입력값 n이 1,000,000이므로 메모리 초과 발생
 * 2차원 배열 dp 할당이 문제인 것으로 예상
 */
public class boj1904 {
    private static int[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        // 2. Biz logic
        dp = new int[n][n / 2 + n % 2];
        int result = binary(n);

        // 3. End
        System.out.println(result % 15746);
    }

    private static int binary(int n) {
        int result = 0;

        int zeroCnt = 0;
        if (n % 2 == 0) {
            result += 2;
            zeroCnt = (n / 2) - 1;
        }
        else {
            
            result += 1;
        }
        
        for (int i = 1; i <= zeroCnt; i++) {
            result += combination(i + (n - (i * 2)), i);
        }

        return result;
    }

    private static int combination(int n, int r) {
        if (r > (n / 2 + n % 2)) {
            if (dp[n][n - r] != 0)
                return dp[n][n - r];
        } else {
            if (dp[n][r] != 0)
                return dp[n][r];
        }

        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
