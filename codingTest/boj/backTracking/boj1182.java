package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1182 {
    private static int n;
    private static int s;
    private static int count = 0;
    private static int[] nums;
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        // 2. Biz logic
        combination(0);
        
        // 3. End
        System.out.println(count);
    }

    private static void combination(int idx) {
        if (!list.isEmpty() && list.stream().mapToInt(Integer::intValue).sum() == s) {
            count++;
        }

        for (int i = idx; i < n; i++) {
            list.add(nums[i]);
            combination(i + 1);
            list.remove(list.indexOf(nums[i]));
        }
    }
}
