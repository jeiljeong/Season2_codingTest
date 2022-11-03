// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Iterator;
// import java.util.LinkedList;
// import java.util.StringTokenizer;

// public class boj2606 {
//     private static ArrayList<Graph> graph;
//     private static int[] visit;
//     public static void main(String[] args) throws NumberFormatException, IOException {
//         // 1. Check input validation & initialization
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int n = Integer.parseInt(br.readLine());

//         visit = new int[n + 1];

//         int edge = Integer.parseInt(br.readLine());

//         graph = new ArrayList<>();
//         graph.add(new Graph(0));
//         for (int i = 1; i <= n; i++) {
//             graph.add(new Graph(i));
//         }

//         StringTokenizer st = null;
//         for (int i = 0; i < edge; i++) {
//             st = new StringTokenizer(br.readLine());

//             int u = Integer.parseInt(st.nextToken());
//             int v = Integer.parseInt(st.nextToken());

//             graph.get(u).addEdge(v);
//             graph.get(v).addEdge(u);
//         }
        
//         // 2. Biz logic
//         dfs(1);
        
//         // 3. End
//         int sum = 0;
//         for (int i = 2; i <= n; i++) {
//             sum += visit[i];
//         }
//         System.out.println(sum); // 1번 제외
//     }
    
//     private static void dfs(int v) {
//         visit[v] = 1;

//         Iterator<Integer> vertex = graph.get(v).getEdgeList().iterator();
//         while (vertex.hasNext()) {
//             int next = vertex.next();
//             if (visit[next] == 0) {
//                 dfs(next);
//             }
//         }
//     }
// }

// class Graph {
//     private int v;
//     private LinkedList<Integer> edgeList;

//     Graph(int v) {
//         this.v = v;
//         this.edgeList = new LinkedList<>();
//     }

//     public int getV() {
//         return v;
//     }
//     public LinkedList<Integer> getEdgeList() {
//         return edgeList;
//     }
//     public void addEdge(int v) {
//         edgeList.add(v);
//     }
// }
