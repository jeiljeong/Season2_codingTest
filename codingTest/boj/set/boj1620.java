package codingTest.boj.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class boj1620 {
    public static void main(String[] args) throws IOException {
        // 1. 입력값 검증
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> dic = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dic.put(i, br.readLine());
        }

        Set<Integer> keySet = dic.keySet();

        // 2. Biz logic
        for (int i = 0; i < m; i++) {
            String quiz = br.readLine();
            char[] charstr = quiz.toCharArray();
            if (charstr[0] >= 0 && charstr[0] <= 9) {
                // number
                System.out.println(dic.get(Integer.parseInt(quiz)));
            } else {
                // string
                for (Integer key : keySet) {
                    if (dic.get(key).equals(quiz)) {
                        System.out.println(key);
                        break;
                    }
                }
            }
        }
        
        // 3. end
    }
}
