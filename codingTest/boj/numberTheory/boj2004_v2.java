package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This algorithms uses the fatorial & exponent
 * 
 * 본 글의 하단 댓글 중 min(2^n cnt, 5^n cnt)에 대한 질의가 있었는데,
 * 해당 내용에 대해 답변이 부족하다고 느끼므로 내가 이해한 바를 통해 작성하자면,
 * 2, 5 중에 0으로 끝나는 수를 나누면, 5가 승수가 더 작을 것이다.
 * 그러나 factorial을 이용하고, 그 과정에서 a1 - b1 - b2가 연산과정에 들어가는데
 * 이는 2의 지수 >= 5의 지수인 상황에서, 최종 지수 연산 결과가 2's n <= 5's n인 경우를 의미한다.
 * 
 * 따라서 min을 구해 결과를 출력하는 것이다.
 * min은 연산결과인 total of 2's n이 매우 작은 상황이거나, 혹은 아무리 2's이 작다고 하더라도 0으로 끝나야 하므로
 * 10 = 2 * 5라는 5's n의 기본 조건을 만족하는 경우를 의미한다.
 * 
 * cf. https://st-lab.tistory.com/166
 */
public class boj2004_v2 {
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        // 2. Biz logic
        long totalPowerNumOfFive    = nPowerof(n, 5) - nPowerof(n - m, 5) - nPowerof(m, 5);
        long totalPowerNumOfTwo     = nPowerof(n, 2) - nPowerof(n - m, 2) - nPowerof(m, 2);
        
        // 3. End
        System.out.println(Math.min(totalPowerNumOfFive, totalPowerNumOfTwo));
    }

    private static long nPowerof(long n, int base) {
        long count = 0;

        while (n >= base) {
            count += n / base;
            n /= base;
        }
        
        return count;
    }
}
