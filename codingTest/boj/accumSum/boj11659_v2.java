import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11659_v2 {
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 2. Biz logic
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(sum(a, b)).append("\n");
        }        
        
        // 3. End
        System.out.println(sb);
    }

    private static int sum(int a, int b) {
        return nums[b] - nums[a - 1];
    }
}
