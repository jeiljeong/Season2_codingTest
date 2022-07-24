package codingTest.boj.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj14425 {
    public static void main(String[] args) throws IOException {
        // 1. 입력값 검증
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> src = new HashSet<>();
        for (int i = 0; i < n; i++) {
            src.add(br.readLine());
        }

        // 2. Biz logic
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (src.contains(br.readLine())) {
                count++;
            }
        }

        // 3. 종료
        System.out.println(count);
    }
}
