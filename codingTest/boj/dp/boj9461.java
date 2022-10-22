import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Point
 * 1) Use Recursive
 * 2) Make sure that variable type is enough to allocate result, because sequence can exceed the limit bound of type
 * 3) f(n) = f(n - 1) + f(n - 5) or f(n) = f(n - 2) + f(n - 3)
 * 4) cf. https://st-lab.tistory.com/127
 */
public class boj9461 {
    private static long[] dp = new long[101];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int N = Integer.parseInt(br.readLine());
            // 2. Biz logic
            System.out.println(P(N));
        }
        
        // 3. End
    }

    private static long P(int N) {
        if (N == 1 || N == 2 || N == 3) {
            return 1;
        } else if (N == 4 || N == 5) {
            return 2;
        }
        if (dp[N] == 0) {
            dp[N] = P(N - 1) + P(N - 5);
        }
        return dp[N];
    }
}
