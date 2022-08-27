package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 본 풀이 과정에서 max는 - % 연산이 수가 작을 때 등장하게 하고,
 * 역으로 min은 * + 연산이 초기에 등장하도록 하는 최적화 과정이 있을 것으로 예상했으나,
 * 이를 구현하는 것은 쉽지 않았기 때문에
 * 
 * 하단의 블로그를 참고해 모든 가능성을 탐색하는 BackTracking 알고리즘으로 진행했음
 * cf. https://st-lab.tistory.com/121
 */
public class boj14888 {
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int n;
    private static int[] nums;
    private static final int[] operator = new int[4];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // 2. Biz logic
        dfs(nums[0], 1);
        
        // 3. End
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int idx) {
        if (idx == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return ;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(num + nums[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - nums[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * nums[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / nums[idx], idx + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
