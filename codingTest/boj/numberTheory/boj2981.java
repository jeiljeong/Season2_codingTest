package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj2981 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. 입력값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 2. 비즈니스 로직
        /**
         * STEP 1 : find GCD between 2 given facotrs, one by one.
         * A1 = M * a1 + r1, A2 = M * a2 + r2
         * if, r1 = r2
         * then, A1 - A2 = M(a1 - a2) + (r1 - r2)
         * A1 - A2 = M(a1 - a2)
         * M = (A1 - A2)'s Common Divisor
         * 
         * if we find that M is GCD,
         * then we can be sure that all of common divisor of M satisfies the given conditional expression
         */
        int prev = Integer.parseInt(br.readLine());
        int gcd = 0;
        int next = 0;
        for (int i = 0; i < n - 1; i++) {
            next = Integer.parseInt(br.readLine());
            gcd = _findGcd(gcd, Math.abs(prev - next));
            prev = next;
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
        // 3. 종료
        Collections.sort(nums);
        nums.forEach(e -> System.out.print(e + " "));
    }

    private static int _findGcd(int a, int b) {
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
