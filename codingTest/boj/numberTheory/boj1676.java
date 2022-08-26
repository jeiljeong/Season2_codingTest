package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 10 = 2 * 5
 * 단순히 Factorial로 구하는 것이 아니라 규칙을 사용
 * cf. https://st-lab.tistory.com/165
 */
public class boj1676 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 0;

        // 2. Biz logic
        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        
        // 3. End
        System.out.println(count);
    }
}
