import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2606_v2 {
    private static ArrayList<Integer>[] a;  // 인접리스트
    private static boolean visit[];         // 정점 방문 체크
    private static int n, m, s;             // 정점, 간선, 시작 정점
    private static int count = 0;           // 정점과 연결된 바이러스 걸리는 컴퓨터 수

    public static int dfs(int i) {
        visit[i] = true;
        for (int k : a[i]) {
            if (visit[k] == false) {
                count++;
                dfs(k);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());    // 정점의 개수
        m = Integer.parseInt(br.readLine());    // 간선 개수
        s = 1;                                  // 시작 정점

        a = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        StringTokenizer st = null;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            a[u].add(v);
            a[v].add(u);
        }

        System.out.println(dfs(s));
    }
}
