import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1) 포도주 시식에서 3번 연속으로 잔을 마시면 안 된다는 것은 아래와 같이 점화식으로 구현할 수 있음
 *    - Math.max(find(n - 2), find(n - 3) + arr[n - 1]) + arr[n]
 *    > 내가 원래 사용하고자 했던 limit와 같은 flag 혹은 cnt 변수로는 적절하지 않음
 *    >>> 느낀점 : dp는 이전의 누적된 합이 어떤 값인지 예측할 수 없으며, top-down의 경우 점화식에 의존함
 * 2) find(n - 1)은 모든 값을 누적시켜서, 연속된 3개의 누적값이 만들어질 수 있기에 위와 같은 불연속적인 점화식을 구성해야 하는 것임
 *    - 즉, Math.max(find(n - 2), find(n - 1)) + arr[n]
 *    > 이러한 식은 arr[n]에 대한 n번 누적합을 만들어낼 뿐임
 * 3) 반드시 마지막 포도주를 마셔야 하는 것은 아니다
 *    - 10, 20, 15, 1의 경우 마지막 1을 반드시 선택해야 한다면 max는 10 + 20 + 1 = 31이지만, 조건이 없는 경우 20 + 15 = 35로 더 큰 누적합이다
 *    - Math.max(Math.max(불연속 누적합 계산 및 dp 할당), find(n - 1))은 합성함수 (불연속누적합)의 arr[n]을 포함하지 않음
 *    > 즉, 모든 n번의 누적합이 구현되지 않으며, 불연속 누적합에 대해 직전 n - 1까지와 n까지의 누적합 중 더 큰 것을 단순 비교하는 식임
 *    >>> 느낀점 : v2 println(Math.max(find(n), find(n - 1))에서 구현하고자 했던 바임, 다른 점이 있다면 마지막에서만 구현하는 것이 아니라 recursion을 반복할 때마다 비교해주는 것이 필요하기에 dp[n] 할당 로직에 들어간 것
 */
public class boj2156_answer {
    private static Integer dp[];
    private static int cup[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        cup = new int[n + 1];

        // 2. Biz logic
        for (int i = 1; i <= n; i++) {
            cup[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = cup[0];
        dp[1] = cup[1];

        if (n >= 2) {
            dp[2] = cup[1] + cup[2];
        }
        
        // 3. End
        System.out.println(find(n));
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(Math.max(find(n - 2), find(n - 3) + cup[n - 1]) + cup[n], find(n - 1));
        }
        return dp[n];
    }
}
