import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Point
 * 1) dp
 *    - Memorization target : the maximum sum before the index i
 * 2) must use recurrence relation
 *    - psum[i] = psum[i - 1] + arr[i]
 * 
 * Keyword
 * 1) Top-Down : means the caller stack by the recursion
 * 2) Bottom-Up : means the iteration that starts from the i to the n
 * cf. https://st-lab.tistory.com/140
 */
public class boj1912 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        int[] dp = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 2. Biz logic
        dp[0] = nums[0];
        // for the final printing without the additional searching.
        int max = nums[0];
        
        for (int i = 1; i < n; i++) {
            // no need to memorize the elements, just need to memorize max sum before index i
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        // 3. End
        System.out.println(max);
    }
}
