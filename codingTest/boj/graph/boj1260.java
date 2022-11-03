import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1260 {
    private static ArrayList<Integer>[] vertex;
    private static boolean visit[];
    private static int n, m, s;
    private static StringBuilder sb;
    
    private static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        vertex = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            vertex[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            vertex[v].add(u);
            vertex[u].add(v);
        }

        for (int i = 1; i <= n; i++) {
            vertex[i].sort(Comparator.naturalOrder());
        }

        queue = new LinkedList<>();

        // 2. Biz logic
        dfs(s);
        sb.append('\n');

        init_visit();

        bfs(s);
        
        // 3. End
        System.out.println(sb);
    }
    private static void init_visit() {
        for (int i = 0; i < n + 1; i++) {
            visit[i] = false;
        }
    }
    private static void dfs(int v) {
        visit[v] = true;
        sb.append(v).append(' ');

        for (int next : vertex[v]) {
            if (visit[next] == false) {
                dfs(next);
            }
        }
    }
    private static void bfs(int v) {
        queue.add(v);
        visit[v] = true;
        
        while (queue.peek() != null) {
            int next = queue.poll();
            sb.append(next).append(' ');
            
            for (int i : vertex[next]) {
                if (visit[i] == false) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}