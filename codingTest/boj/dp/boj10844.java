package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP를 사용하는 곳에서 포인트를 잡지 못했으나
 * N번째 자리수에서 value 8이 나올 때를 가정하면, dp[n][8]에는 피호출자에서 반환한 누적값이 들어가 있으며,
 * n + 1번째 자리수에서 value 7과 9에서 n번째 자리수 value 8을 호출할 수 있는데
 * 최초 호출된 7의 연산과정을 모두 수행 시 9의 연산은 dp를 통해 반환된 값으로 연산된다는 점에 시간을 줄일 수 있는 것이다.
 * 
 * Point
 * 1) DP
 * 2) long
 * 3) modulor 분배법칙 사용
 * cf. https://www.acmicpc.net/problem/10844
 */
public class boj10844 {
    private static int n;
    private static long MOD = 1_000_000_000;
    /**
     * 경우의 수 저장
     */
    private static Long[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        dp = new Long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        // 2. Biz logic
        for (int i = 1; i <= 9; i++) {
            result += comb(n, i);
        }
        
        // 3. End
        System.out.println(result % MOD);
    }

    private static long comb(int digit, int val) {
        if (digit == 1) {
            /**
             * 1로 초기화된 첫번째 자리 수의 경우의 수를 반환
             */
            return dp[digit][val];
        }
        
        if (dp[digit][val] == null) {
            if (val == 0) {
                dp[digit][val] = comb(digit - 1, 1);
            }
            else if (val == 9) {
                dp[digit][val] = comb(digit - 1, 8);
            }
            else {
                dp[digit][val] = comb(digit - 1, val - 1) + comb(digit - 1, val + 1);
            }
        }

        return dp[digit][val] % MOD;
    }
}
