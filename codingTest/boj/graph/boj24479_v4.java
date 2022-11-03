// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.StringTokenizer;

// public class boj24479_v4 {
//     private static int[] visit;
//     private static int cnt;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//         StringTokenizer st = new StringTokenizer(br.readLine());
        
//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());
//         int s = Integer.parseInt(st.nextToken());

//         ArrayList<Graph> vertex = new ArrayList<>();
//         visit = new int[n + 1];
//         cnt = 0;

//         // 노드 생성
//         for (int i = 0; i <= n; i++) {
//             vertex.add(new Graph());
//         }

//         // 간선 정보 삽입
//         for (int i = 0; i < m; i++) {
//             st = new StringTokenizer(br.readLine());

//             int v = Integer.parseInt(st.nextToken());
//             int u = Integer.parseInt(st.nextToken());

//             vertex.get(v).getEdgeList().add(u);
//             vertex.get(u).getEdgeList().add(v);
//         }

//         // 연결 노드 오름차순 정렬
//         for (int i = 1; i <= n; i++) {
//             vertex.get(i).getEdgeList().sort(Comparator.naturalOrder());
//         }

//         // DFS
//         dfs(vertex, s);

//         // 결과 출력
//         StringBuilder sb = new StringBuilder();
//         for (int i = 1; i <= n; i++) {
//             sb.append(visit[i]).append('\n');
//         }
//         System.out.println(sb);
//     }

//     private static void dfs(ArrayList<Graph> vertex, int v) {
//         visit[v] = ++cnt;

//         for (int i : vertex.get(v).getEdgeList()) {
//             if (visit[i] == 0) {
//                 dfs(vertex, i);
//             }
//         }
//     }
// }

// class Graph {
//     private ArrayList<Integer> edgeList;

//     Graph() {
//         this.edgeList = new ArrayList<>();
//     }

//     public ArrayList<Integer> getEdgeList() {
//         return edgeList;
//     }
// }