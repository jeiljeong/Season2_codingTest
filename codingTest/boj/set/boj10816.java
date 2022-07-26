package codingTest.boj.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj10816 {
    /**
     * @param args
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. 입력값 검증
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. Biz logic
        int n = Integer.parseInt(br.readLine());
        StringTokenizer nStr = new StringTokenizer(br.readLine());
        // input, cnt
        Map<String, Integer> nums = new HashMap<>();
        String key = null;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            key = nStr.nextToken();
            if (nums.containsKey(key)) {
                cnt = nums.get(key) + 1;
                nums.replace(key, cnt);
            } else {
                nums.put(key, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        StringTokenizer mStr = new StringTokenizer(br.readLine());
        String quizKey = null;
        for (int i = 0; i < m; i++) {
            quizKey = mStr.nextToken();
            if (nums.containsKey(quizKey)) {
                sb.append(nums.get(quizKey)).append(" ");
            } else {
                sb.append("0").append(" ");
            }
        }

        // 3. end
        System.out.println(sb);
    }
}
