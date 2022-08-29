package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6603 {
    private static int[] nums;
    private static boolean[] visit;
    private static StringBuilder sb;
    private static int k;
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        while (k != 0) {
            // Set the arrays
            sb = new StringBuilder();

            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            visit = new boolean[k];

            // 2. Biz logic
            combination(0, 0);

            System.out.println(sb);
            System.out.println();

            // Read the next line
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
        }
        
        // 3. End
    }

    private static void combination(int idx, int depth) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (visit[i]) {
                    sb.append(nums[i]).append(' ');
                }
            }
            sb.append('\n');

            return ;
        }

        if (!visit[idx]) {
            visit[idx] = true;
            for (int i = idx; i < k; i++) {
                combination(i, depth + 1);
            }
            visit[idx] = false;
        }
    }
}
