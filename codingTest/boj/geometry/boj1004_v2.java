package codingTest.boj.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1004_v2 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int answer = 0;

            // 1. 입력값 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            // 2. 비즈니스 로직
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int radius = Integer.parseInt(st.nextToken());

                boolean isIncludedStart = false;
                boolean isIncludedEnd = false;

                if (Math.pow(startX - x, 2) + Math.pow(startY - y, 2)
                    < Math.pow(radius, 2)) {
                        isIncludedStart = true;
                }
                if (Math.pow(endX - x, 2) + Math.pow(endY - y, 2)
                    < Math.pow(radius, 2)) {
                        isIncludedEnd = true;
                }

                if (isIncludedStart != isIncludedEnd) answer++;
            }
            // 3. 결과값 출력
            System.out.println(answer);
        }
        // 4. 종료
    }
}
