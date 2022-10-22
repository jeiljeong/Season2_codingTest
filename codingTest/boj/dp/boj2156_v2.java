import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2156_v2 {
    // 아래 부분을 점화식으로 구현할 수 있음
    // private static int limit = 0;

    private static Integer dp[];
    private static int cup[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        cup = new int[n + 1];

        // 2. Biz logic
        for (int i = 1; i <= n; i++) {
            cup[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = cup[0];
        dp[1] = cup[1];

        if (n >= 2) {
            dp[2] = cup[1] + cup[2];
        }
        
        // 3. End
        System.out.println(Math.max(find(n), find(n - 1)));
        // -> 문제점 : 이미 계산된 DP는 이전의 누적합을 보여주기 때문에 find(n)과 find(n - 1) 차이를 반영하지 못한다.
        // 사실상 위의 println() 내부의 Math.max는 누적합 dp에 영향을 주지 않아, 의미가 없는 것
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(find(n - 2), find(n - 3) + cup[n - 1]) + cup[n];
        }
        return dp[n];
    }
}
