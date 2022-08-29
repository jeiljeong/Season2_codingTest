package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Point
 * 1) 재귀를 이용한 dfs와 backTracking(조건은 6까지 뽑기)
 * 2) combination -> 중복 뽑기 불가(visit[i] 이용), 순서 역행 불가(idx 이용)
 */
public class boj6603_v2 {
    private static int[] nums;
    private static boolean[] visit;
    private static int k;
    private static final StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        k = Integer.parseInt(st.nextToken());
        
        // 2. Biz logic
        while (k != 0) {
            nums = new int[k];
            visit = new boolean[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            
            combination(0, 0);

            sb.append('\n');

            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
        }
        
        // 3. End
        System.out.println(sb);
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

        for (int i = idx; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}
