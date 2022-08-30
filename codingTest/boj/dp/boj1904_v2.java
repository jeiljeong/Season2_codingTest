package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * v1에서는 combination(이향계수의 파스칼의 삼각형)을 이용해 2차원 배열에 저장 - 메모리 초과 오류
 * v2에서는 fibonachi 수열을 이용해 2차원 배열에 저장
 * cf. https://st-lab.tistory.com/125
 */
public class boj1904_v2 {
    private static int[] dp = new int[1000001];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2; // dp[3] = 3으로 dp[1] + dp[2]부터 dp연산이 가능하기에 index 2까지는 초기화

        // 2. Biz logic
        /**
         * 1) 피보나치 수열의 경우 기하급수적으로 결과값이 커질 수 있으며, int의 범위를 넘어갈 수 있음
         * 2) input의 제한값은 1백만으로, int overflow를 방지하기 위해 modulo 분배법칙을 활용
         *    - (A + B) % C = ((A % C) + (B % C)) % C
         * 3) dp에는 나머지가 저장되므로 dp를 -1로 초기화
         * 4) 재귀 활용
         */
        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }
        
        // 3. End
        System.out.println(tile(n));
    }

    private static int tile(int n) {
        if (dp[n] == -1) {
            dp[n] = (tile(n - 1) + tile(n - 2)) % 15746;
        }
        return dp[n];
    }
}
