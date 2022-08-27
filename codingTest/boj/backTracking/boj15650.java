package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 방문 후 = false 로 재할당 하는 행위를 트리의 수직적 구조가 아닌, 횡 배열의 형태로 이해하면 좋음
 * 즉, n = true 설정 시 해당 노드는 방문 대상에서 제외하고, depth 탈출 시 다음 반복문으로 n + 1번째 노드를 자연스럽게 방문하는데
 * depth가 + 1단계 깊어지는 상황(즉, dfs가 다시 호출되는 경우)에는 다음 호출된 dfs에서 n을 방문할 수 있다는 것
 * 즉, n이 방문 대상에 포함된다는 것을 의미함 -> 따라서 수직적 구조로 이해하는 것이 이해를 방해함
 * 
 * 참고할 점은 이 트리가 n에 의해 순차적으로 증가하는 digit으로, 간단히 구현될 수 있다는 점에 유의할 것
 */
/**
 * 따라서 상기의 이해를 바탕으로 수평적 구조로 노드 방문을 이해한다면
 * 숫자가 역행할 수 있음(즉 오름차순이 아님)
 * 본 문제에서 반드시 오름차순일 경우만 출력한다고 했기 때문에
 * start 파라미터를 추가하여, n + 1번째 노드에서는 n 이하를 방문할 수 없도록 제외하는 것이 필요
 */
public class boj15650 {
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
        dfs(n, m, 1, 0);

        // 3. End
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int start, int depth) {
        // Limitation of visit
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return ;
        }

        // Every nodes for visiting
        for (int i = start; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(n, m, i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}
