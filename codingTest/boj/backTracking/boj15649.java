package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj15649
 * 1) 길이가 M을 만족시키는 모든 digit의 조합은 Combination을 활용할 수 있음
 * 2) 그러나 이 문제는 길이가 M을 만족시키는 모든 수열의 목록을 출력하는 것
 * 3) 단순히 모든 경우를 점검하는 BruteForce가 아닌, 유망성을 중심으로 탐색하는 BackTracking에 해당하며, 구현은 DFS 사용
 * 
 * 특징
 * 1) 주어진 N은 숫자의 집합이며, 방문 노드로 표현 가능
 * 2) 주어진 M 길이 -> 유망성 점검 기준 -> 백트래킹 방법을 사용
 * 3) 노드를 트리로 표현하여, 방문 체크 -> DFS 알고리즘
 * 
 * 결론
 * 1) BackTracking
 * 2) DFS
 * 
 * cf. https://st-lab.tistory.com/114
 */
/**
 * 방문 후 = false 로 재할당 하는 행위를 트리의 수직적 구조가 아닌, 횡 배열의 형태로 이해하면 좋음
 * 즉, n = true 설정 시 해당 노드는 방문 대상에서 제외하고, depth 탈출 시 다음 반복문으로 n + 1번째 노드를 자연스럽게 방문하는데
 * depth가 + 1단계 깊어지는 상황(즉, dfs가 다시 호출되는 경우)에는 다음 호출된 dfs에서 n을 방문할 수 있다는 것
 * 즉, n이 방문 대상에 포함된다는 것을 의미함 -> 따라서 수직적 구조로 이해하는 것이 이해를 방해함
 * 
 * 참고할 점은 이 트리가 n에 의해 순차적으로 증가하는 digit으로, 간단히 구현될 수 있다는 점에 유의할 것
 */
public class boj15649 {
    private static boolean[] visit;
    private static int[] arr;
    private static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        visit = new boolean[n + 1];
        arr = new int[m];
    
        // 2. Biz logic
        dfs(n, m, 0);
        
        // 3. End
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            
            return ;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(n, m, depth + 1);
                visit[i] = false;
            }
        }
    }
}