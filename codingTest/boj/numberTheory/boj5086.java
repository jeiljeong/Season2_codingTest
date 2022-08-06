package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj5086 {
    private static final String R_FACTOR = "factor";
    private static final String R_MULITPLE = "multiple";
    private static final String R_NEITHER = "neither";


    public static void main(String[] args) throws IOException {
        // 1. 입력값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = null;
        while (true) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 2. 비즈니스 로직
            if (a == 0 && b == 0)
            break;
            
            String result = "";
            if (a < b) {
                result = b % a == 0 ? R_FACTOR : R_NEITHER;
            } else if (a > b) {
                result = a % b == 0 ? R_MULITPLE : R_NEITHER;
            }
            System.out.println(result);
        }
        // 3. 종료
    }
}
