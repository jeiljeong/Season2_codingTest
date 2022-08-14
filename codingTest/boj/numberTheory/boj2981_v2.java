package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj2981_v2 {
    /**
     * Point 1 : 두 입력값 사이의 차를 구하는 것에 대한 이해
     * Point 2 : GCD 알고리즘
     * Point 3 : Math.sqrt()를 이용해 모든 약수를 구하기
     * @param args
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. 입력값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 2. 비즈니스 로직
        /**
         * STEP 1
         * if)
         * A1 = a1 * M + r
         * A2 = a2 * M + r
         * A1 - A2 = (a1 - a2) * M
         * 해설 : n번째과 n + 1번째 입력된 값의 차를 구하고, 이를 Sn이라고 할 때, Sn의 최대공약수를 찾는 문제
         */
        /**
         * 입력값 처리를 for문을 돌며, 메모리(추가적 공간)를 사용하지 않는 방법이 있음
         */
        int sub = 0;
        int gcd = 0;
        int a1 = Integer.parseInt(br.readLine());
        int a2 = 0;
        for (int i = 1; i < n; i++) {
            a2 = Integer.parseInt(br.readLine());
            sub = Math.abs(a2 - a1);
            // 초기 예외, 즉 n = 2일 때
            if (i == 1)
                gcd = sub;
            gcd = _getGcd(gcd, sub);
            a1 = a2;
        }
        
        /**
         * STEP 2 : find all of common divisor of GCD by using effective Math.sqrt() algorithm;
         */
        int sqrt_gcd = (int) Math.sqrt(gcd);
        List<Integer> nums = new ArrayList<>();
        for (int i = 2; i <= sqrt_gcd; i++) {
            if (gcd % i == 0) {
                nums.add(i);
                if (gcd / i != i) {
                    nums.add(gcd / i);
                }
            }
        }
        // 1을 제외한 자기자신을 삽입
        nums.add(gcd);

        // 3. 종료
        Collections.sort(nums);
        nums.forEach(e -> System.out.print(e + " "));
    }

    private static int _getGcd(int a, int b) {
        // swap
        if (a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        
        int remain = a % b;
        while (remain != 0) {
            a = b;
            b = remain;
            remain = a % b;
        }

        return b;
    }
}
