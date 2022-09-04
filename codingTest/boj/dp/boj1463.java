package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Point - 본 문제는 문제의 풀이법을 연상하기 어려웠음.
 * 1) 2, 3, -1 의 연산이 있다
 * 2) 각각의 연산이 입력값 n에 적용된다
 * 3) 연산 수의 결과값이 dp에 저장된다
 * 4) 2, 3으로 나누어 떨어진다는 것은 각 수로 나누었을 때와 -1 연산을 했을 때 최소가 되는지 재귀를 호출하는 것이다.
 *    - 추가적으로 재귀 호출 시 파라미터 순서는 -1이 더 늦게 나와야 하는데, 이는 -1 연산이 먼저 파라미터 값으로 등장할 경우, 모든 경우에 대해 dp를 실시해 수행시간이 초과되기 때문이다
 * 5) 2, 3의 최소공배수인 6의 경우에 어떤 수의 연산이 더 짧은 연산인지 2, 3, -1 모두 시도해 봐야 한다.
 * 
 * dp 풀이법
 * 1) 이전 문제에서 정리했던 depth 체크, 방문 체크, memorization value return, 연산 등으로 구성됨
 * 2) 연속된 수식의 점화식을 구하고, 점화식을 수식으로 나타냄
 * 3) 문제의 조건에 따른 경우의 수를 나눠 각각의 점화식을 구성
 * 4) int의 범위, 파라미터 호출 순서에 따른 dp 성능 등을 고려해 문제를 다듬기
 * 
 * cf. https://st-lab.tistory.com/133?category=868019
 */
public class boj1463 {
    private static Integer[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        dp = new Integer[n + 1];
        
        // 2. Biz logic
        dp[0] = dp[1] = 0;
        
        // 3. End
        System.out.println(recur(n));
    }

    private static int recur(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
            }
            else if (n % 3 == 0) {
                dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
            }
            else if (n % 2 == 0) {
                dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
            }
            else {
                dp[n] = recur(n - 1) + 1;
            }
        }
        
        return dp[n];
    }
}
