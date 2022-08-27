package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * version 2에서는 방문체크용 visit 배열이 없음
 * 기본적으로 방문 체크는 중복 방문을 방지하기 위한 것
 * 그러나 at을 통해 역행하는 것을 방지하고 있기 때문에, 기본적으로 순차 증가하는 i값이 역행하지 않을 때
 * 중복 방문이 일어날 수 없음 -> 따라서 별도의 boolean[] visit 없이 구현
 */
public class boj15650_v2 {
    private static int[] arr;
    private static int n;
    private static int m;
    private static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];

        // 2. Biz logic
        dfs(1, 0);
        
        // 3. End
        System.out.println(sb);
    }

    private static void dfs(int at, int depth) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for (int i = at; i <= n; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
