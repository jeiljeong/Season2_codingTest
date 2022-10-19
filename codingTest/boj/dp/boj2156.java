package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2156 {
    private static int n;
    private static int[] cup;
    private static Integer[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        cup = new int[n];
        dp = new Integer[n];

        for (int i = 0; i < n; i ++) {
            cup[i] = Integer.parseInt(br.readLine());
        }
        
        // 2. Biz logic
        recur(n - 1, 0);

        
        // 3. End
        
    }

    private static int recur(int depth, int count) {
        if (depth < 0 || count == 3) {
            return 0;
        }

        if (dp[depth] == null) {
            if (count == 0) {
                /**
                 * 1) 연달아 2개 선택한 경우
                 * 2) 1개 선택된 경우
                 */
                dp[depth] = recur(depth - 1, count++) + cup[depth];
            }
            else if (count == 1) {
                dp[depth] = recur(depth - 2, count++) + cup[depth];
            }
            else if (count == 2) {

            }
        }

        return dp[depth];
    }
}
