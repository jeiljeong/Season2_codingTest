package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다리 수를 구하는 것은 조합(nCr)을 이용하는 것과 같음
 * cf. https://st-lab.tistory.com/194
 */
public class boj1010 {
    private static int[][] dp = new int[30][30];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(br.readLine());
        
        StringTokenizer st = null;
        for (int i = 0; i < lines; i++) {
            st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            // 2. Biz logic
            System.out.println(combi(m, n));
        }
        // 3. End
    }

    private static int combi(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r | r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}
